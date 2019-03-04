/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.dmn.client.graph;

import java.util.Optional;
import java.util.stream.StreamSupport;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.kie.workbench.common.dmn.api.definition.v1_1.DMNDiagram;
import org.kie.workbench.common.dmn.api.definition.v1_1.Definitions;
import org.kie.workbench.common.stunner.core.client.api.SessionManager;
import org.kie.workbench.common.stunner.core.client.canvas.CanvasHandler;
import org.kie.workbench.common.stunner.core.client.session.ClientSession;
import org.kie.workbench.common.stunner.core.diagram.Diagram;
import org.kie.workbench.common.stunner.core.graph.Graph;
import org.kie.workbench.common.stunner.core.graph.Node;
import org.kie.workbench.common.stunner.core.graph.content.definition.Definition;

@Dependent
public class DMNGraphUtils {

    private static Definitions NONE = null;

    private SessionManager sessionManager;

    public DMNGraphUtils() {
        //CDI proxy
    }

    @Inject
    public DMNGraphUtils(final SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public Definitions getDefinitions() {
        return getCurrentSession()
                .map(clientSession -> {
                    return getCanvasHandler(clientSession)
                            .map(canvasHandler -> getDefinitions(canvasHandler.getDiagram()))
                            .orElse(NONE);
                })
                .orElse(NONE);
    }

    @SuppressWarnings("unchecked")
    public Definitions getDefinitions(final Diagram diagram) {

        final Graph<?, Node> graph = diagram.getGraph();

        return StreamSupport
                .stream(graph.nodes().spliterator(), false)
                .map(Node::getContent)
                .filter(c -> c instanceof Definition)
                .map(c -> (Definition) c)
                .map(Definition::getDefinition)
                .filter(d -> d instanceof DMNDiagram)
                .map(d -> (DMNDiagram) d)
                .findFirst()
                .map(DMNDiagram::getDefinitions)
                .orElse(NONE);
    }

    private Optional<ClientSession> getCurrentSession() {
        return Optional.ofNullable(sessionManager.getCurrentSession());
    }

    private Optional<CanvasHandler> getCanvasHandler(final ClientSession session) {
        return Optional.ofNullable(session.getCanvasHandler());
    }
}
