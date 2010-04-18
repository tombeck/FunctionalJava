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

import com.freiheit.jafp.function.Function1;
import com.freiheit.jafp.function.Function2;
import com.freiheit.jafp.predicate.Predicate2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 10.06.2007
 */
public final class _Double {

    public static final class Increment_ implements Function1<Double, Double> {

        public static final Increment_ INSTANCE = new Increment_();

        public Double call(Double arg1) {

            return arg1.doubleValue() + 1;
        }

    }

    public static final class Decrement_ implements Function1<Double, Double> {

        public static final Decrement_ INSTANCE = new Decrement_();

        public Double call(Double arg1) {

            return arg1.doubleValue() - 1;
        }

    }

    public static final class Negate_ implements Function1<Double, Double> {

        public static final Negate_ INSTANCE = new Negate_();

        public Double call(Double arg1) {

            return -arg1.doubleValue();
        }

    }

    public static final class Multiply_ implements Function2<Double, Double, Double> {

        public static final Multiply_ INSTANCE = new Multiply_();

        public Double call(Double arg1, Double arg2) {

            return arg1.doubleValue() * arg2.doubleValue();
        }

    }

    public static final class Divide_ implements Function2<Double, Double, Double> {

        public static final Divide_ INSTANCE = new Divide_();

        public Double call(Double arg1, Double arg2) {

            return arg1.doubleValue() / arg2.doubleValue();
        }

    }

    public static final class Remainder_ implements Function2<Double, Double, Double> {

        public static final Remainder_ INSTANCE = new Remainder_();

        public Double call(Double arg1, Double arg2) {

            return arg1.doubleValue() % arg2.doubleValue();
        }

    }

    public static final class Add_ implements Function2<Double, Double, Double> {

        public static final Add_ INSTANCE = new Add_();

        public Double call(Double arg1, Double arg2) {

            return arg1.doubleValue() + arg2.doubleValue();
        }

    }

    public static final class Subtract_ implements Function2<Double, Double, Double> {

        public static final Subtract_ INSTANCE = new Subtract_();

        public Double call(Double arg1, Double arg2) {

            return arg1.doubleValue() - arg2.doubleValue();
        }

    }

    public static final class Less_ extends Predicate2<Double, Double> {

        public static final Less_ INSTANCE = new Less_();

        @Override
        public boolean appliesTo(Double arg1, Double arg2) {

            return arg1.doubleValue() < arg2.doubleValue();
        }

    }

    public static final class Greater_ extends Predicate2<Double, Double> {
        
        public static final Greater_ INSTANCE = new Greater_();
        
        @Override
        public boolean appliesTo(Double arg1, Double arg2) {
            
            return arg1.doubleValue() > arg2.doubleValue();
        }
        
    }
    
    public static final class LessEqual_ extends Predicate2<Double, Double> {

        public static final LessEqual_ INSTANCE = new LessEqual_();

        @Override
        public boolean appliesTo(Double arg1, Double arg2) {

            return arg1.doubleValue() <= arg2.doubleValue();
        }

    }

    public static final class GreaterEqual_ extends Predicate2<Double, Double> {

        public static final GreaterEqual_ INSTANCE = new GreaterEqual_();

        @Override
        public boolean appliesTo(Double arg1, Double arg2) {

            return arg1.doubleValue() > arg2.doubleValue();
        }

    }

    public static final class Equal_ extends Predicate2<Double, Double> {

        public static final Equal_ INSTANCE = new Equal_();

        @Override
        public boolean appliesTo(Double arg1, Double arg2) {

            return arg1.doubleValue() == arg2.doubleValue();
        }

    }

    public static final class NotEqual_ extends Predicate2<Double, Double> {

        public static final NotEqual_ INSTANCE = new NotEqual_();

        @Override
        public boolean appliesTo(Double arg1, Double arg2) {

            return arg1.doubleValue() != arg2.doubleValue();
        }

    }

    public static Function1<Double, Double> increment_() {

        return Increment_.INSTANCE;
    }

    public static Function1<Double, Double> decrement_() {
        
        return Decrement_.INSTANCE;
    }
    
    public static Function1<Double, Double> negate_() {

        return Negate_.INSTANCE;
    }

    public static Function2<Double, Double, Double> multiply_() {

        return Multiply_.INSTANCE;
    }

    public static Function2<Double, Double, Double> divide_() {

        return Divide_.INSTANCE;
    }

    public static Function2<Double, Double, Double> remainder_() {

        return Remainder_.INSTANCE;
    }

    public static Function2<Double, Double, Double> add_() {

        return Add_.INSTANCE;
    }

    public static Function2<Double, Double, Double> subtract_() {

        return Subtract_.INSTANCE;
    }

    public static Predicate2<Double, Double> less_() {

        return Less_.INSTANCE;
    }

    public static Predicate2<Double, Double> greater_() {

        return Greater_.INSTANCE;
    }

    public static Predicate2<Double, Double> lessEqual_() {

        return LessEqual_.INSTANCE;
    }

    public static Predicate2<Double, Double> greaterEqual_() {

        return GreaterEqual_.INSTANCE;
    }

    public static Predicate2<Double, Double> equal_() {

        return Equal_.INSTANCE;
    }

    public static Predicate2<Double, Double> notEqual_() {

        return NotEqual_.INSTANCE;
    }

}
