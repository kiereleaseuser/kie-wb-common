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

package org.kie.workbench.common.stunner.core.rule.context.impl;

import java.util.Optional;
import java.util.Set;

import org.kie.workbench.common.stunner.core.rule.RuleEvaluationContext;
import org.kie.workbench.common.stunner.core.rule.context.CardinalityContext;

class CardinalityContextImpl implements CardinalityContext {

    private final String name;
    private final Set<String> roles;
    private final int count;
    private final Optional<Operation> operation;

    CardinalityContextImpl(final String name,
                           final Set<String> roles,
                           final int count,
                           final Optional<Operation> operation) {
        this.name = name;
        this.roles = roles;
        this.count = count;
        this.operation = operation;
    }

    @Override
    public Set<String> getRoles() {
        return roles;
    }

    @Override
    public int getCandidateCount() {
        return count;
    }

    @Override
    public Optional<Operation> getOperation() {
        return operation;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDefaultDeny() {
        return false;
    }

    @Override
    public Class<? extends RuleEvaluationContext> getType() {
        return CardinalityContext.class;
    }
}