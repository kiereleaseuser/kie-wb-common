/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.stunner.core.client.canvas.command;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.workbench.common.stunner.core.client.command.CanvasViolation;
import org.kie.workbench.common.stunner.core.client.shape.MutationContext;
import org.kie.workbench.common.stunner.core.command.CommandResult;
import org.kie.workbench.common.stunner.core.graph.Node;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith( MockitoJUnitRunner.class )
public class RemoveCanvasChildCommandTest extends AbstractCanvasCommandTest {

    private static final String PARENT_ID = "e1";
    private static final String CHILD_ID = "s1";

    @Mock private Node parent;
    @Mock private Node child;

    private RemoveCanvasChildCommand tested;

    @Before
    public void setup() throws Exception {
        super.setup();
        when( parent.getUUID() ).thenReturn( PARENT_ID );
        when( child.getUUID() ).thenReturn( CHILD_ID );
        this.tested = new RemoveCanvasChildCommand( parent, child );
    }

    @Test
    @SuppressWarnings( "unchecked" )
    public void testExecute() {
        final CommandResult<CanvasViolation> result = tested.execute( canvasHandler );
        assertNotEquals( CommandResult.Type.ERROR, result.getType() );
        verify( canvasHandler, times( 1 ) ).removeChild( eq( PARENT_ID ), eq( CHILD_ID ) );
        verify( canvasHandler, times( 1 ) ).applyElementMutation( eq( parent ), any( MutationContext.class ) );
        verify( canvasHandler, times( 1 ) ).applyElementMutation( eq( child ), any( MutationContext.class ) );
    }

}
