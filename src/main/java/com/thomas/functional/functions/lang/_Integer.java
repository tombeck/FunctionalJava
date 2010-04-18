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
public final class _Integer {

    public static final class Increment_ implements Function1<Integer, Integer> {

        public static final Increment_ INSTANCE = new Increment_();

        public Integer call(Integer arg1) {

            return arg1.intValue() + 1;
        }

    }

    public static final class Decrement_ implements Function1<Integer, Integer> {

        public static final Decrement_ INSTANCE = new Decrement_();

        public Integer call(Integer arg1) {

            return arg1.intValue() - 1;
        }

    }

    public static final class Negate_ implements Function1<Integer, Integer> {

        public static final Negate_ INSTANCE = new Negate_();

        public Integer call(Integer arg1) {

            return -arg1.intValue();
        }

    }

    public static final class Complement_ implements Function1<Integer, Integer> {

        public static final Complement_ INSTANCE = new Complement_();

        public Integer call(Integer arg1) {

            return ~arg1.intValue();
        }

    }

    public static final class Multiply_ implements Function2<Integer, Integer, Integer> {

        public static final Multiply_ INSTANCE = new Multiply_();

        public Integer call(Integer arg1, Integer arg2) {

            return arg1.intValue() * arg2.intValue();
        }

    }

    public static final class Divide_ implements Function2<Integer, Integer, Integer> {

        public static final Divide_ INSTANCE = new Divide_();

        public Integer call(Integer arg1, Integer arg2) {

            return arg1.intValue() / arg2.intValue();
        }

    }

    public static final class Remainder_ implements Function2<Integer, Integer, Integer> {

        public static final Remainder_ INSTANCE = new Remainder_();

        public Integer call(Integer arg1, Integer arg2) {

            return arg1.intValue() % arg2.intValue();
        }

    }

    public static final class Add_ implements Function2<Integer, Integer, Integer> {

        public static final Add_ INSTANCE = new Add_();

        public Integer call(Integer arg1, Integer arg2) {

            return arg1.intValue() + arg2.intValue();
        }

    }

    public static final class Subtract_ implements Function2<Integer, Integer, Integer> {

        public static final Subtract_ INSTANCE = new Subtract_();

        public Integer call(Integer arg1, Integer arg2) {

            return arg1.intValue() - arg2.intValue();
        }

    }

    public static final class ShiftLeft_ implements Function2<Integer, Integer, Integer> {

        public static final ShiftLeft_ INSTANCE = new ShiftLeft_();

        public Integer call(Integer arg1, Integer arg2) {

            return arg1.intValue() << arg2.intValue();
        }

    }

    public static final class ShiftRight_ implements Function2<Integer, Integer, Integer> {

        public static final ShiftRight_ INSTANCE = new ShiftRight_();

        public Integer call(Integer arg1, Integer arg2) {

            return arg1.intValue() >> arg2.intValue();
        }

    }

    public static final class UnsignedShiftRight_ implements Function2<Integer, Integer, Integer> {

        public static final UnsignedShiftRight_ INSTANCE = new UnsignedShiftRight_();

        public Integer call(Integer arg1, Integer arg2) {

            return arg1.intValue() >>> arg2.intValue();
        }

    }

    public static final class Less_ extends Predicate2<Integer, Integer> {

        public static final Less_ INSTANCE = new Less_();

        @Override
        public boolean appliesTo(Integer arg1, Integer arg2) {

            return arg1.intValue() < arg2.intValue();
        }

    }

    public static final class Greater_ extends Predicate2<Integer, Integer> {
        
        public static final Greater_ INSTANCE = new Greater_();
        
        @Override
        public boolean appliesTo(Integer arg1, Integer arg2) {
            
            return arg1.intValue() > arg2.intValue();
        }
        
    }
    
    public static final class LessEqual_ extends Predicate2<Integer, Integer> {

        public static final LessEqual_ INSTANCE = new LessEqual_();

        @Override
        public boolean appliesTo(Integer arg1, Integer arg2) {

            return arg1.intValue() <= arg2.intValue();
        }

    }

    public static final class GreaterEqual_ extends Predicate2<Integer, Integer> {

        public static final GreaterEqual_ INSTANCE = new GreaterEqual_();

        @Override
        public boolean appliesTo(Integer arg1, Integer arg2) {

            return arg1.intValue() > arg2.intValue();
        }

    }

    public static final class Equal_ extends Predicate2<Integer, Integer> {

        public static final Equal_ INSTANCE = new Equal_();

        @Override
        public boolean appliesTo(Integer arg1, Integer arg2) {

            return arg1.intValue() == arg2.intValue();
        }

    }

    public static final class NotEqual_ extends Predicate2<Integer, Integer> {

        public static final NotEqual_ INSTANCE = new NotEqual_();

        @Override
        public boolean appliesTo(Integer arg1, Integer arg2) {

            return arg1.intValue() != arg2.intValue();
        }

    }

    public static final class And_ implements Function2<Integer, Integer, Integer> {

        public static final And_ INSTANCE = new And_();

        @Override
        public Integer call(Integer arg1, Integer arg2) {

            return arg1.intValue() & arg2.intValue();
        }

    }

    public static final class XOr_ implements Function2<Integer, Integer, Integer> {
        
        public static final XOr_ INSTANCE = new XOr_();
        
        public Integer call(Integer arg1, Integer arg2) {
            
            return arg1.intValue() ^ arg2.intValue();
        }
        
    }
    
    public static final class Or_ implements Function2<Integer, Integer, Integer> {

        public static final Or_ INSTANCE = new Or_();

        public Integer call(Integer arg1, Integer arg2) {

            return arg1.intValue() | arg2.intValue();
        }

    }

    public static final class Min_ implements Function2<Integer, Integer, Integer> {

        public static final Min_ INSTANCE = new Min_();

        public Integer call(Integer arg1, Integer arg2) {

            return Math.min(arg1.intValue(), arg2.intValue());
        }

    }

    public static final class Max_ implements Function2<Integer, Integer, Integer> {

        public static final Max_ INSTANCE = new Max_();

        public Integer call(Integer arg1, Integer arg2) {

            return Math.max(arg1.intValue(), arg2.intValue());
        }

    }

    public static Function1<Integer, Integer> increment_() {

        return Increment_.INSTANCE;
    }

    public static Function1<Integer, Integer> decrement_() {
        
        return Decrement_.INSTANCE;
    }
    
    public static Function1<Integer, Integer> negate_() {

        return Negate_.INSTANCE;
    }

    public static Function1<Integer, Integer> complement_() {
        
        return Complement_.INSTANCE;
    }
    
    public static Function2<Integer, Integer, Integer> multiply_() {

        return Multiply_.INSTANCE;
    }

    public static Function2<Integer, Integer, Integer> divide_() {

        return Divide_.INSTANCE;
    }

    public static Function2<Integer, Integer, Integer> remainder_() {

        return Remainder_.INSTANCE;
    }

    public static Function2<Integer, Integer, Integer> add_() {

        return Add_.INSTANCE;
    }

    public static Function2<Integer, Integer, Integer> subtract_() {

        return Subtract_.INSTANCE;
    }

    public static Function2<Integer, Integer, Integer> shiftLeft_() {

        return ShiftLeft_.INSTANCE;
    }

    public static Function2<Integer, Integer, Integer> shiftRight_() {

        return ShiftRight_.INSTANCE;
    }

    public static Function2<Integer, Integer, Integer> unsignedShiftRight_() {

        return UnsignedShiftRight_.INSTANCE;
    }

    public static Predicate2<Integer, Integer> less_() {

        return Less_.INSTANCE;
    }

    public static Predicate2<Integer, Integer> greater_() {

        return Greater_.INSTANCE;
    }

    public static Predicate2<Integer, Integer> lessEqual_() {

        return LessEqual_.INSTANCE;
    }

    public static Predicate2<Integer, Integer> greaterEqual_() {

        return GreaterEqual_.INSTANCE;
    }

    public static Predicate2<Integer, Integer> equal_() {

        return Equal_.INSTANCE;
    }

    public static Predicate2<Integer, Integer> notEqual_() {

        return NotEqual_.INSTANCE;
    }

    public static Function2<Integer, Integer, Integer> and_() {

        return And_.INSTANCE;
    }

    public static Function2<Integer, Integer, Integer> xor_() {
        
        return XOr_.INSTANCE;
    }
    
    public static Function2<Integer, Integer, Integer> or_() {

        return Or_.INSTANCE;
    }

    public static Function2<Integer, Integer, Integer> min_() {

        return Min_.INSTANCE;
    }

    public static Function2<Integer, Integer, Integer> max_() {

        return Max_.INSTANCE;
    }

}
