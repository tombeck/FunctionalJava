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
package com.freiheit.jafp.functions.lang;

import com.freiheit.jafp.function.Function3;
import com.freiheit.jafp.predicate.Predicate1;
import com.freiheit.jafp.predicate.Predicate2;

/**
 * TODO Type documentation
 *
 * @author Thomas
 * @since 10.06.2007
 */
public final class _Boolean {

    public static final class Not_ extends Predicate1<Boolean> {

        public static final Not_ INSTANCE = new Not_();

        @Override
        public boolean appliesTo(Boolean arg1) {

            return !arg1;
        }

    }

    public static final class XOr_ extends Predicate2<Boolean, Boolean> {

        public static final XOr_ INSTANCE = new XOr_();

        @Override
        public boolean appliesTo(Boolean arg1, Boolean arg2) {

            return arg1 ^ arg2;
        }

    }

    public static final class And_ extends Predicate2<Boolean, Boolean> {

        public static final And_ INSTANCE = new And_();

        @Override
        public boolean appliesTo(Boolean arg1, Boolean arg2) {

            return arg1 && arg2;
        }

    }

    public static final class Or_ extends Predicate2<Boolean, Boolean> {
        
        public static final Or_ INSTANCE = new Or_();
        
        @Override
        public boolean appliesTo(Boolean arg1, Boolean arg2) {
            
            return arg1 || arg2;
        }
        
    }
    
    public static final class Conditional<T> implements Function3<T, Boolean, T, T> {

        public static final Conditional<Object> INSTANCE = new Conditional<Object>();

        public T call(Boolean arg1, T arg2, T arg3) {

            return arg1 ? arg2 : arg3;
        }

    }

    public static Predicate1<Boolean> not_() {
        
        return Not_.INSTANCE;
    }
    
    public static Predicate2<Boolean, Boolean> xor_() {
        
        return XOr_.INSTANCE;
    }
    
    public static Predicate2<Boolean, Boolean> and_() {
        
        return And_.INSTANCE;
    }
    
    public static Predicate2<Boolean, Boolean> or_() {
        
        return Or_.INSTANCE;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> Function3<T, Boolean, T, T> conditional_() {
        
        return (Conditional<T>)Conditional.INSTANCE;
    }
    
}
