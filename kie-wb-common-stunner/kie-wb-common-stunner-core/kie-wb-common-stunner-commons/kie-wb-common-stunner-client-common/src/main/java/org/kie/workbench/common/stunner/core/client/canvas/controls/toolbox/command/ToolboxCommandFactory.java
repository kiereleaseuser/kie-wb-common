/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.stunner.core.client.canvas.controls.toolbox.command;

import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.ManagedInstance;
import org.kie.workbench.common.stunner.core.client.canvas.controls.toolbox.command.actions.MoveShapeDownToolboxCommand;
import org.kie.workbench.common.stunner.core.client.canvas.controls.toolbox.command.actions.MoveShapeUpToolboxCommand;
import org.kie.workbench.common.stunner.core.client.canvas.controls.toolbox.command.actions.RemoveToolboxCommand;
import org.kie.workbench.common.stunner.core.client.canvas.controls.toolbox.command.builder.NewConnectorCommand;
import org.kie.workbench.common.stunner.core.client.canvas.controls.toolbox.command.builder.NewNodeCommand;

public abstract class ToolboxCommandFactory {

    private final ManagedInstance<NewNodeCommand> newNodeCommands;
    private final ManagedInstance<NewConnectorCommand> newConnectorCommands;

    @Inject
    public ToolboxCommandFactory( final ManagedInstance<NewNodeCommand> newNodeCommands,
                                  final ManagedInstance<NewConnectorCommand> newConnectorCommands ) {
        this.newNodeCommands = newNodeCommands;
        this.newConnectorCommands = newConnectorCommands;
    }

    public abstract RemoveToolboxCommand<?> newRemoveToolboxCommand();

    public abstract MoveShapeUpToolboxCommand<?> newMoveShapeUpToolboxCommand();

    public abstract MoveShapeDownToolboxCommand<?> newMoveShapeDownToolboxCommand();

    public NewNodeCommand<?> newNodeCommand() {
        return newNodeCommands.get();
    }

    public NewConnectorCommand<?> newConnectorCommand() {
        return newConnectorCommands.get();
    }
}
