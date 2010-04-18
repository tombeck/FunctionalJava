/**
 * $Id$
 *
 * Copyright (c) 2007 Thomas Beckmann 
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.thomas.functional.functions.lang;

import com.thomas.functional.function.Function2;
import com.thomas.functional.predicate.Predicate2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 04.01.2007
 */
public final class _Class {

    public static final class Cast_<T> implements Function2<T, Class<T>, Object> {

        public static final Cast_<Object> INSTANCE = new Cast_<Object>();

        public T call(Class<T> arg1, Object arg2) {

            return arg1.cast(arg2);
        }

    }

    public static final class IsInstance extends Predicate2<Class<?>, Object> {

        public static final IsInstance INSTANCE = new IsInstance();

        @Override
        public boolean appliesTo(Class<?> arg1, Object arg2) {

            return arg1.isInstance(arg2);
        }

    }

    @SuppressWarnings("unchecked")
    public static <T> Function2<T, Class<T>, Object> cast() {

        return (Cast_<T>)Cast_.INSTANCE;
    }

    public static Predicate2<Class<?>, Object> isInstance() {

        return IsInstance.INSTANCE;
    }

}
