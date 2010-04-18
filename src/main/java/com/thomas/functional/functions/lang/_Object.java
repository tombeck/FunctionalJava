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

import com.thomas.functional.function.Function1;
import com.thomas.functional.predicate.Predicate2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 04.01.2007
 */
public final class _Object {

    public static final class Equals_ extends Predicate2<Object, Object> {

        public static final Equals_ INSTANCE = new Equals_();

        @Override
        public boolean appliesTo(Object arg1, Object arg2) {

            return arg1.equals(arg2);
        }

    }

    public static final class GetClass_ implements Function1<Class<?>, Object> {

        public static final GetClass_ INSTANCE = new GetClass_();

        public Class<?> call(Object arg1) {

            return arg1.getClass();
        }

    }

    public static final class HashCode_ implements Function1<Integer, Object> {

        public static final HashCode_ INSTANCE = new HashCode_();

        public Integer call(Object arg1) {

            return arg1.hashCode();
        }

    }

    public static final class NullSafeEquals_ extends Predicate2<Object, Object> {

        public static final NullSafeEquals_ INSTANCE = new NullSafeEquals_();

        @Override
        public boolean appliesTo(Object arg1, Object arg2) {

            return arg1 == null ? arg2 == null : arg1.equals(arg2);
        }

    }

    public static final class ToString_ implements Function1<String, Object> {

        public static final ToString_ INSTANCE = new ToString_();

        public String call(Object arg1) {

            return arg1.toString();
        }

    }

    public static final class Same extends Predicate2<Object, Object> {
        
        public static final Same INSTANCE = new Same();
        
        @Override
        public boolean appliesTo(Object arg1, Object arg2) {
            
            return arg1 == arg2;
        }
        
    }
    
    public static final class NotSame extends Predicate2<Object, Object> {

        public static final NotSame INSTANCE = new NotSame();

        @Override
        public boolean appliesTo(Object arg1, Object arg2) {

            return arg1 != arg2;
        }

    }

    public static Predicate2<Object, Object> equals_() {

        return Equals_.INSTANCE;
    }

    public static Function1<Class<?>, Object> getClass_() {

        return GetClass_.INSTANCE;
    }

    public static Function1<Integer, Object> hashCode_() {

        return HashCode_.INSTANCE;
    }

    public static Predicate2<Object, Object> nullSafeEquals_() {

        return NullSafeEquals_.INSTANCE;
    }

    public static Function1<String, Object> toString_() {

        return ToString_.INSTANCE;
    }

    public static Predicate2<Object, Object> same() {
        
        return Same.INSTANCE;
    }
    
    public static Predicate2<Object, Object> notSame() {
        
        return NotSame.INSTANCE;
    }
    
}
