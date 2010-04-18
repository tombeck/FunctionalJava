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
public final class _Long {

    public static final class Increment_ implements Function1<Long, Long> {

        public static final Increment_ INSTANCE = new Increment_();

        public Long call(Long arg1) {

            return arg1.longValue() + 1;
        }

    }

    public static final class Decrement_ implements Function1<Long, Long> {

        public static final Decrement_ INSTANCE = new Decrement_();

        public Long call(Long arg1) {

            return arg1.longValue() - 1;
        }

    }

    public static final class Negate_ implements Function1<Long, Long> {

        public static final Negate_ INSTANCE = new Negate_();

        public Long call(Long arg1) {

            return -arg1.longValue();
        }

    }

    public static final class Complement_ implements Function1<Long, Long> {

        public static final Complement_ INSTANCE = new Complement_();

        public Long call(Long arg1) {

            return ~arg1.longValue();
        }

    }

    public static final class Multiply_ implements Function2<Long, Long, Long> {

        public static final Multiply_ INSTANCE = new Multiply_();

        public Long call(Long arg1, Long arg2) {

            return arg1.longValue() * arg2.longValue();
        }

    }

    public static final class Divide_ implements Function2<Long, Long, Long> {

        public static final Divide_ INSTANCE = new Divide_();

        public Long call(Long arg1, Long arg2) {

            return arg1.longValue() / arg2.longValue();
        }

    }

    public static final class Remainder_ implements Function2<Long, Long, Long> {

        public static final Remainder_ INSTANCE = new Remainder_();

        public Long call(Long arg1, Long arg2) {

            return arg1.longValue() % arg2.longValue();
        }

    }

    public static final class Add_ implements Function2<Long, Long, Long> {

        public static final Add_ INSTANCE = new Add_();

        public Long call(Long arg1, Long arg2) {

            return arg1.longValue() + arg2.longValue();
        }

    }

    public static final class Subtract_ implements Function2<Long, Long, Long> {

        public static final Subtract_ INSTANCE = new Subtract_();

        public Long call(Long arg1, Long arg2) {

            return arg1.longValue() - arg2.longValue();
        }

    }

    public static final class ShiftLeft_ implements Function2<Long, Long, Integer> {

        public static final ShiftLeft_ INSTANCE = new ShiftLeft_();

        public Long call(Long arg1, Integer arg2) {

            return arg1.longValue() << arg2.intValue();
        }

    }

    public static final class ShiftRight_ implements Function2<Long, Long, Integer> {

        public static final ShiftRight_ INSTANCE = new ShiftRight_();

        public Long call(Long arg1, Integer arg2) {

            return arg1.longValue() >> arg2.intValue();
        }

    }

    public static final class UnsignedShiftRight_ implements Function2<Long, Long, Integer> {

        public static final UnsignedShiftRight_ INSTANCE = new UnsignedShiftRight_();

        public Long call(Long arg1, Integer arg2) {

            return arg1.longValue() >>> arg2.intValue();
        }

    }

    public static final class Less_ extends Predicate2<Long, Long> {

        public static final Less_ INSTANCE = new Less_();

        @Override
        public boolean appliesTo(Long arg1, Long arg2) {

            return arg1.longValue() < arg2.longValue();
        }

    }

    public static final class Greater_ extends Predicate2<Long, Long> {
        
        public static final Greater_ INSTANCE = new Greater_();
        
        @Override
        public boolean appliesTo(Long arg1, Long arg2) {
            
            return arg1.longValue() > arg2.longValue();
        }
        
    }
    
    public static final class LessEqual_ extends Predicate2<Long, Long> {

        public static final LessEqual_ INSTANCE = new LessEqual_();

        @Override
        public boolean appliesTo(Long arg1, Long arg2) {

            return arg1.longValue() <= arg2.longValue();
        }

    }

    public static final class GreaterEqual_ extends Predicate2<Long, Long> {

        public static final GreaterEqual_ INSTANCE = new GreaterEqual_();

        @Override
        public boolean appliesTo(Long arg1, Long arg2) {

            return arg1.longValue() > arg2.longValue();
        }

    }

    public static final class Equal_ extends Predicate2<Long, Long> {

        public static final Equal_ INSTANCE = new Equal_();

        @Override
        public boolean appliesTo(Long arg1, Long arg2) {

            return arg1.longValue() == arg2.longValue();
        }

    }

    public static final class NotEqual_ extends Predicate2<Long, Long> {

        public static final NotEqual_ INSTANCE = new NotEqual_();

        @Override
        public boolean appliesTo(Long arg1, Long arg2) {

            return arg1.longValue() != arg2.longValue();
        }

    }

    public static final class And_ implements Function2<Long, Long, Long> {

        public static final And_ INSTANCE = new And_();

        public Long call(Long arg1, Long arg2) {

            return arg1.longValue() & arg2.intValue();
        }

    }

    public static final class XOr_ implements Function2<Long, Long, Long> {
        
        public static final XOr_ INSTANCE = new XOr_();
        
        public Long call(Long arg1, Long arg2) {
            
            return arg1.longValue() ^ arg2.intValue();
        }
        
    }
    
    public static final class Or_ implements Function2<Long, Long, Long> {

        public static final Or_ INSTANCE = new Or_();

        public Long call(Long arg1, Long arg2) {

            return arg1.longValue() | arg2.intValue();
        }

    }

    public static Function1<Long, Long> increment_() {

        return Increment_.INSTANCE;
    }

    public static Function1<Long, Long> decrement_() {
        
        return Decrement_.INSTANCE;
    }
    
    public static Function1<Long, Long> negate_() {

        return Negate_.INSTANCE;
    }

    public static Function1<Long, Long> complement_() {
        
        return Complement_.INSTANCE;
    }
    
    public static Function2<Long, Long, Long> multiply_() {

        return Multiply_.INSTANCE;
    }

    public static Function2<Long, Long, Long> divide_() {

        return Divide_.INSTANCE;
    }

    public static Function2<Long, Long, Long> remainder_() {

        return Remainder_.INSTANCE;
    }

    public static Function2<Long, Long, Long> add_() {

        return Add_.INSTANCE;
    }

    public static Function2<Long, Long, Long> subtract_() {

        return Subtract_.INSTANCE;
    }

    public static Function2<Long, Long, Integer> shiftLeft_() {

        return ShiftLeft_.INSTANCE;
    }

    public static Function2<Long, Long, Integer> shiftRight_() {

        return ShiftRight_.INSTANCE;
    }

    public static Function2<Long, Long, Integer> unsignedShiftRight_() {

        return UnsignedShiftRight_.INSTANCE;
    }

    public static Predicate2<Long, Long> less_() {

        return Less_.INSTANCE;
    }

    public static Predicate2<Long, Long> greater_() {

        return Greater_.INSTANCE;
    }

    public static Predicate2<Long, Long> lessEqual_() {

        return LessEqual_.INSTANCE;
    }

    public static Predicate2<Long, Long> greaterEqual_() {

        return GreaterEqual_.INSTANCE;
    }

    public static Predicate2<Long, Long> equal_() {

        return Equal_.INSTANCE;
    }

    public static Predicate2<Long, Long> notEqual_() {

        return NotEqual_.INSTANCE;
    }

    public static Function2<Long, Long, Long> and_() {

        return And_.INSTANCE;
    }

    public static Function2<Long, Long, Long> xor_() {
        
        return XOr_.INSTANCE;
    }
    
    public static Function2<Long, Long, Long> or_() {

        return Or_.INSTANCE;
    }

}
