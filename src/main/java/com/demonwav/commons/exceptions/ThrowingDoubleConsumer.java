/*
 * Copyright 2018 Kyle Wood (DemonWav)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.demonwav.commons.exceptions;

import java.util.function.DoubleConsumer;

@FunctionalInterface
public interface ThrowingDoubleConsumer extends DoubleConsumer {

    /**
     * Delegates to {@link #acceptThrowing(double)}.
     */
    @Override
    default void accept(double value) {
        try {
            acceptThrowing(value);
        } catch (final Throwable throwable) {
            throw Throwing.throwAnyways(throwable);
        }
    }

    void acceptThrowing(double value) throws Throwable;
}
