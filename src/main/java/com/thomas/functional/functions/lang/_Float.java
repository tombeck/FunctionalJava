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
import com.thomas.functional.function.Function2;
import com.thomas.functional.predicate.Predicate2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 10.06.2007
 */
public final class _Float {

    public static final class Increment_ implements Function1<Float, Float> {

        public static final Increment_ INSTANCE = new Increment_();

        public Float call(Float arg1) {

            return arg1.floatValue() + 1;
        }

    }

    public static final class Decrement_ implements Function1<Float, Float> {

        public static final Decrement_ INSTANCE = new Decrement_();

        public Float call(Float arg1) {

            return arg1.floatValue() - 1;
        }

    }

    public static final class Negate_ implements Function1<Float, Float> {

        public static final Negate_ INSTANCE = new Negate_();

        public Float call(Float arg1) {

            return -arg1.floatValue();
        }

    }

    public static final class Multiply_ implements Function2<Float, Float, Float> {

        public static final Multiply_ INSTANCE = new Multiply_();

        public Float call(Float arg1, Float arg2) {

            return arg1.floatValue() * arg2.floatValue();
        }

    }

    public static final class Divide_ implements Function2<Float, Float, Float> {

        public static final Divide_ INSTANCE = new Divide_();

        public Float call(Float arg1, Float arg2) {

            return arg1.floatValue() / arg2.floatValue();
        }

    }

    public static final class Remainder_ implements Function2<Float, Float, Float> {

        public static final Remainder_ INSTANCE = new Remainder_();

        public Float call(Float arg1, Float arg2) {

            return arg1.floatValue() % arg2.floatValue();
        }

    }

    public static final class Add_ implements Function2<Float, Float, Float> {

        public static final Add_ INSTANCE = new Add_();

        public Float call(Float arg1, Float arg2) {

            return arg1.floatValue() + arg2.floatValue();
        }

    }

    public static final class Subtract_ implements Function2<Float, Float, Float> {

        public static final Subtract_ INSTANCE = new Subtract_();

        public Float call(Float arg1, Float arg2) {

            return arg1.floatValue() - arg2.floatValue();
        }

    }

    public static final class Less_ extends Predicate2<Float, Float> {

        public static final Less_ INSTANCE = new Less_();

        @Override
        public boolean appliesTo(Float arg1, Float arg2) {

            return arg1.floatValue() < arg2.floatValue();
        }


    }

    public static final class Greater_ extends Predicate2<Float, Float> {
        
        public static final Greater_ INSTANCE = new Greater_();
        
        @Override
        public boolean appliesTo(Float arg1, Float arg2) {
            
            return arg1.floatValue() > arg2.floatValue();
        }
        
    }
    
    public static final class LessEqual_ extends Predicate2<Float, Float> {

        public static final LessEqual_ INSTANCE = new LessEqual_();

        @Override
        public boolean appliesTo(Float arg1, Float arg2) {

            return arg1.floatValue() <= arg2.floatValue();
        }

    }

    public static final class GreaterEqual_ extends Predicate2<Float, Float> {

        public static final GreaterEqual_ INSTANCE = new GreaterEqual_();

        @Override
        public boolean appliesTo(Float arg1, Float arg2) {

            return arg1.floatValue() > arg2.floatValue();
        }

    }

    public static final class Equal_ extends Predicate2<Float, Float> {

        public static final Equal_ INSTANCE = new Equal_();

        @Override
        public boolean appliesTo(Float arg1, Float arg2) {

            return arg1.floatValue() == arg2.floatValue();
        }

    }

    public static final class NotEqual_ extends Predicate2<Float, Float> {

        public static final NotEqual_ INSTANCE = new NotEqual_();

        @Override
        public boolean appliesTo(Float arg1, Float arg2) {

            return arg1.floatValue() != arg2.floatValue();
        }

    }

    public static Function1<Float, Float> increment_() {

        return Increment_.INSTANCE;
    }

    public static Function1<Float, Float> decrement_() {
        
        return Decrement_.INSTANCE;
    }
    
    public static Function1<Float, Float> negate_() {

        return Negate_.INSTANCE;
    }

    public static Function2<Float, Float, Float> multiply_() {

        return Multiply_.INSTANCE;
    }

    public static Function2<Float, Float, Float> divide_() {

        return Divide_.INSTANCE;
    }

    public static Function2<Float, Float, Float> remainder_() {

        return Remainder_.INSTANCE;
    }

    public static Function2<Float, Float, Float> add_() {

        return Add_.INSTANCE;
    }

    public static Function2<Float, Float, Float> subtract_() {

        return Subtract_.INSTANCE;
    }

    public static Predicate2<Float, Float> less_() {

        return Less_.INSTANCE;
    }

    public static Predicate2<Float, Float> greater_() {

        return Greater_.INSTANCE;
    }

    public static Predicate2<Float, Float> lessEqual_() {

        return LessEqual_.INSTANCE;
    }

    public static Predicate2<Float, Float> greaterEqual_() {

        return GreaterEqual_.INSTANCE;
    }

    public static Predicate2<Float, Float> equal_() {

        return Equal_.INSTANCE;
    }

    public static Predicate2<Float, Float> notEqual_() {

        return NotEqual_.INSTANCE;
    }

}
