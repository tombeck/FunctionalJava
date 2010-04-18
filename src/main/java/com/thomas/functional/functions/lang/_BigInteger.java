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

import java.math.BigInteger;

import com.thomas.functional.function.Function1;
import com.thomas.functional.function.Function2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 17.06.2007
 */
public final class _BigInteger {

    public static final class Negate implements Function1<BigInteger, BigInteger> {

        public static final Negate INSTANCE = new Negate();

        public BigInteger call(BigInteger arg1) {

            return arg1.negate();
        }

    }

    public static final class Not implements Function1<BigInteger, BigInteger> {

        public static final Not INSTANCE = new Not();

        public BigInteger call(BigInteger arg1) {

            return arg1.not();
        }

    }

    public static final class Multiply implements Function2<BigInteger, BigInteger, BigInteger> {

        public static final Multiply INSTANCE = new Multiply();

        public BigInteger call(BigInteger arg1, BigInteger arg2) {

            return arg1.multiply(arg2);
        }

    }

    public static final class Divide implements Function2<BigInteger, BigInteger, BigInteger> {

        public static final Divide INSTANCE = new Divide();

        public BigInteger call(BigInteger arg1, BigInteger arg2) {

            return arg1.divide(arg2);
        }

    }

    public static final class Remainder implements Function2<BigInteger, BigInteger, BigInteger> {

        public static final Remainder INSTANCE = new Remainder();

        public BigInteger call(BigInteger arg1, BigInteger arg2) {

            return arg1.remainder(arg2);
        }

    }

    public static final class Add implements Function2<BigInteger, BigInteger, BigInteger> {

        public static final Add INSTANCE = new Add();

        public BigInteger call(BigInteger arg1, BigInteger arg2) {

            return arg1.add(arg2);
        }

    }

    public static final class Subtract implements Function2<BigInteger, BigInteger, BigInteger> {

        public static final Subtract INSTANCE = new Subtract();

        public BigInteger call(BigInteger arg1, BigInteger arg2) {

            return arg1.subtract(arg2);
        }

    }

    public static final class ShiftLeft implements Function2<BigInteger, BigInteger, Integer> {

        public static final ShiftLeft INSTANCE = new ShiftLeft();

        public BigInteger call(BigInteger arg1, Integer arg2) {

            return arg1.shiftLeft(arg2);
        }

    }

    public static final class ShiftRight implements Function2<BigInteger, BigInteger, Integer> {

        public static final ShiftRight INSTANCE = new ShiftRight();

        public BigInteger call(BigInteger arg1, Integer arg2) {

            return arg1.shiftRight(arg2);
        }

    }

    public static final class And implements Function2<BigInteger, BigInteger, BigInteger> {

        public static final And INSTANCE = new And();

        public BigInteger call(BigInteger arg1, BigInteger arg2) {

            return arg1.and(arg2);
        }

    }

    public static final class XOr implements Function2<BigInteger, BigInteger, BigInteger> {
        
        public static final XOr INSTANCE = new XOr();
        
        public BigInteger call(BigInteger arg1, BigInteger arg2) {
            
            return arg1.xor(arg2);
        }
        
    }
    
    public static final class Or implements Function2<BigInteger, BigInteger, BigInteger> {

        public static final Or INSTANCE = new Or();

        public BigInteger call(BigInteger arg1, BigInteger arg2) {

            return arg1.or(arg2);
        }

    }

    public static Function1<BigInteger, BigInteger> negate() {

        return Negate.INSTANCE;
    }

    public static Function1<BigInteger, BigInteger> not() {
        
        return Not.INSTANCE;
    }
    
    public static Function2<BigInteger, BigInteger, BigInteger> multiply() {

        return Multiply.INSTANCE;
    }

    public static Function2<BigInteger, BigInteger, BigInteger> divide() {

        return Divide.INSTANCE;
    }

    public static Function2<BigInteger, BigInteger, BigInteger> remainder() {

        return Remainder.INSTANCE;
    }

    public static Function2<BigInteger, BigInteger, BigInteger> add() {

        return Add.INSTANCE;
    }

    public static Function2<BigInteger, BigInteger, BigInteger> subtract() {

        return Subtract.INSTANCE;
    }

    public static Function2<BigInteger, BigInteger, Integer> shiftLeft() {

        return ShiftLeft.INSTANCE;
    }

    public static Function2<BigInteger, BigInteger, Integer> shiftRight() {

        return ShiftRight.INSTANCE;
    }

    public static Function2<BigInteger, BigInteger, BigInteger> and() {

        return And.INSTANCE;
    }

    public static Function2<BigInteger, BigInteger, BigInteger> xor() {
        
        return XOr.INSTANCE;
    }
    
    public static Function2<BigInteger, BigInteger, BigInteger> or() {

        return Or.INSTANCE;
    }

}
