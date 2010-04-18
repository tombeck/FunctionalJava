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
public final class _Byte {

    public static final class Increment implements Function1<Integer, Byte> {

        public static final Increment INSTANCE = new Increment();

        public Integer call(Byte arg1) {

            return arg1.byteValue() + 1;
        }

    }

    public static final class Decrement implements Function1<Integer, Byte> {

        public static final Decrement INSTANCE = new Decrement();

        public Integer call(Byte arg1) {

            return arg1.byteValue() - 1;
        }

    }

    public static final class Negate implements Function1<Integer, Byte> {

        public static final Negate INSTANCE = new Negate();

        public Integer call(Byte arg1) {

            return -arg1.byteValue();
        }

    }

    public static final class Complement implements Function1<Integer, Byte> {

        public static final Complement INSTANCE = new Complement();

        public Integer call(Byte arg1) {

            return ~arg1.byteValue();
        }

    }

    public static final class Multiply implements Function2<Integer, Byte, Byte> {

        public static final Multiply INSTANCE = new Multiply();

        public Integer call(Byte arg1, Byte arg2) {

            return arg1.byteValue() * arg2.byteValue();
        }

    }

    public static final class Divide implements Function2<Integer, Byte, Byte> {

        public static final Divide INSTANCE = new Divide();

        public Integer call(Byte arg1, Byte arg2) {

            return arg1.byteValue() / arg2.byteValue();
        }

    }

    public static final class Remainder implements Function2<Integer, Byte, Byte> {

        public static final Remainder INSTANCE = new Remainder();

        public Integer call(Byte arg1, Byte arg2) {

            return arg1.byteValue() % arg2.byteValue();
        }

    }

    public static final class Add implements Function2<Integer, Byte, Byte> {

        public static final Add INSTANCE = new Add();

        public Integer call(Byte arg1, Byte arg2) {

            return arg1.byteValue() + arg2.byteValue();
        }

    }

    public static final class Subtract implements Function2<Integer, Byte, Byte> {

        public static final Subtract INSTANCE = new Subtract();

        public Integer call(Byte arg1, Byte arg2) {

            return arg1.byteValue() - arg2.byteValue();
        }

    }

    public static final class ShiftLeft implements Function2<Integer, Byte, Integer> {

        public static final ShiftLeft INSTANCE = new ShiftLeft();

        public Integer call(Byte arg1, Integer arg2) {

            return arg1.byteValue() << arg2.intValue();
        }

    }

    public static final class ShiftRight implements Function2<Integer, Byte, Integer> {

        public static final ShiftRight INSTANCE = new ShiftRight();

        public Integer call(Byte arg1, Integer arg2) {

            return arg1.byteValue() >> arg2.intValue();
        }

    }

    public static final class UnsignedShiftRight implements Function2<Integer, Byte, Integer> {

        public static final UnsignedShiftRight INSTANCE = new UnsignedShiftRight();

        public Integer call(Byte arg1, Integer arg2) {

            return arg1.byteValue() >>> arg2.intValue();
        }

    }

    public static final class Less extends Predicate2<Byte, Byte> {

        public static final Less INSTANCE = new Less();

        @Override
        public boolean appliesTo(Byte arg1, Byte arg2) {

            return arg1.byteValue() < arg2.byteValue();
        }

    }

    public static final class Greater extends Predicate2<Byte, Byte> {
        
        public static final Greater INSTANCE = new Greater();
        
        @Override
        public boolean appliesTo(Byte arg1, Byte arg2) {
            
            return arg1.byteValue() > arg2.byteValue();
        }
        
    }
    
    public static final class LessEqual extends Predicate2<Byte, Byte> {

        public static final LessEqual INSTANCE = new LessEqual();

        @Override
        public boolean appliesTo(Byte arg1, Byte arg2) {

            return arg1.byteValue() <= arg2.byteValue();
        }

    }

    public static final class GreaterEqual extends Predicate2<Byte, Byte> {

        public static final GreaterEqual INSTANCE = new GreaterEqual();

        @Override
        public boolean appliesTo(Byte arg1, Byte arg2) {

            return arg1.byteValue() > arg2.byteValue();
        }

    }

    public static final class Equal extends Predicate2<Byte, Byte> {

        public static final Equal INSTANCE = new Equal();

        @Override
        public boolean appliesTo(Byte arg1, Byte arg2) {

            return arg1.byteValue() == arg2.byteValue();
        }

    }

    public static final class NotEqual extends Predicate2<Byte, Byte> {

        public static final NotEqual INSTANCE = new NotEqual();

        @Override
        public boolean appliesTo(Byte arg1, Byte arg2) {

            return arg1.byteValue() != arg2.byteValue();
        }

    }

    public static final class And implements Function2<Integer, Byte, Byte> {

        public static final And INSTANCE = new And();

        public Integer call(Byte arg1, Byte arg2) {

            return arg1.byteValue() & arg2.intValue();
        }

    }

    public static final class XOr implements Function2<Integer, Byte, Byte> {
        
        public static final XOr INSTANCE = new XOr();
        
        public Integer call(Byte arg1, Byte arg2) {
            
            return arg1.byteValue() ^ arg2.intValue();
        }
        
    }
    
    public static final class Or implements Function2<Integer, Byte, Byte> {

        public static final Or INSTANCE = new Or();

        public Integer call(Byte arg1, Byte arg2) {

            return arg1.byteValue() | arg2.intValue();
        }

    }

    public static Function1<Integer, Byte> increment() {

        return Increment.INSTANCE;
    }

    public static Function1<Integer, Byte> decrement() {
        
        return Decrement.INSTANCE;
    }
    
    public static Function1<Integer, Byte> negate() {

        return Negate.INSTANCE;
    }

    public static Function1<Integer, Byte> complement() {
        
        return Complement.INSTANCE;
    }
    
    public static Function2<Integer, Byte, Byte> multiply() {

        return Multiply.INSTANCE;
    }

    public static Function2<Integer, Byte, Byte> divide() {

        return Divide.INSTANCE;
    }

    public static Function2<Integer, Byte, Byte> remainder() {

        return Remainder.INSTANCE;
    }

    public static Function2<Integer, Byte, Byte> add() {

        return Add.INSTANCE;
    }

    public static Function2<Integer, Byte, Byte> subtract() {

        return Subtract.INSTANCE;
    }

    public static Function2<Integer, Byte, Integer> shiftLeft() {

        return ShiftLeft.INSTANCE;
    }

    public static Function2<Integer, Byte, Integer> shiftRight() {

        return ShiftRight.INSTANCE;
    }

    public static Function2<Integer, Byte, Integer> unsignedShiftRight() {

        return UnsignedShiftRight.INSTANCE;
    }

    public static Predicate2<Byte, Byte> less() {

        return Less.INSTANCE;
    }

    public static Predicate2<Byte, Byte> greater() {

        return Greater.INSTANCE;
    }

    public static Predicate2<Byte, Byte> lessEqual() {

        return LessEqual.INSTANCE;
    }

    public static Predicate2<Byte, Byte> greaterEqual() {

        return GreaterEqual.INSTANCE;
    }

    public static Predicate2<Byte, Byte> equal() {

        return Equal.INSTANCE;
    }

    public static Predicate2<Byte, Byte> notEqual() {

        return NotEqual.INSTANCE;
    }

    public static Function2<Integer, Byte, Byte> and() {

        return And.INSTANCE;
    }

    public static Function2<Integer, Byte, Byte> xor() {
        
        return XOr.INSTANCE;
    }
    
    public static Function2<Integer, Byte, Byte> or() {

        return Or.INSTANCE;
    }

}
