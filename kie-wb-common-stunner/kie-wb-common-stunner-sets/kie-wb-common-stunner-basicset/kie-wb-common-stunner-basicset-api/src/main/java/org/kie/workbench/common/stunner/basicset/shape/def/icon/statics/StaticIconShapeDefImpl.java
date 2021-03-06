/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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

package org.kie.workbench.common.stunner.basicset.shape.def.icon.statics;

import org.kie.workbench.common.stunner.basicset.definition.icon.statics.StaticIcon;
import org.kie.workbench.common.stunner.core.definition.shape.AbstractShapeDef;
import org.kie.workbench.common.stunner.core.definition.shape.GlyphDef;
import org.kie.workbench.common.stunner.core.definition.shape.GlyphDefinitions;
import org.kie.workbench.common.stunner.shapes.def.icon.statics.IconShapeDef;
import org.kie.workbench.common.stunner.shapes.def.icon.statics.Icons;

public class StaticIconShapeDefImpl
        extends AbstractShapeDef<StaticIcon>
        implements IconShapeDef<StaticIcon> {

    private static final String COLOR = "#000000";
    private static final String DESCRIPTION = "An icon";

    @Override
    public Icons getIcon( final StaticIcon element ) {
        return element.getIcon();
    }

    @Override
    public GlyphDef<StaticIcon> getGlyphDef() {
        return GlyphDefinitions.GLYPH_SHAPE();
    }

}
