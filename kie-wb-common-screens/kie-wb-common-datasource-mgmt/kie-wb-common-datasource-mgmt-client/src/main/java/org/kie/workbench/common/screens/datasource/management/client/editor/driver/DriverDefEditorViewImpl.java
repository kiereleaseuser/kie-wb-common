/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.screens.datasource.management.client.editor.driver;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.IsWidget;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.kie.workbench.common.screens.datasource.management.client.editor.common.DefEditorBaseViewImpl;

@Dependent
@Templated
public class DriverDefEditorViewImpl
        extends DefEditorBaseViewImpl
        implements DriverDefEditorView {

    @Inject
    @DataField ( "content-panel" )
    private FlowPanel contentPanel;

    private Presenter presenter;

    public DriverDefEditorViewImpl( ) {
    }

    @Override
    public void init( final Presenter presenter ) {
        this.presenter = presenter;
        super.init( presenter );
    }

    @Override
    public void setContent( IsWidget content ) {
        contentPanel.add( content );
    }
}