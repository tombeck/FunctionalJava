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

import java.math.BigDecimal;

import com.freiheit.jafp.function.Function1;
import com.freiheit.jafp.function.Function2;

/**
 * TODO Type documentation
 *
 * @author Thomas
 * @since 10.06.2007
 */
public final class _BigDecimal {

    public static final class Negate implements Function1<BigDecimal, BigDecimal> {

        public static final Negate INSTANCE = new Negate();

        public BigDecimal call(BigDecimal arg1) {

            return arg1.negate();
        }

    }

    public static final class Multiply implements Function2<BigDecimal, BigDecimal, BigDecimal> {

        public static final Multiply INSTANCE = new Multiply();

        public BigDecimal call(BigDecimal arg1, BigDecimal arg2) {

            return arg1.multiply(arg2);
        }

    }

    public static final class Divide implements Function2<BigDecimal, BigDecimal, BigDecimal> {

        public static final Divide INSTANCE = new Divide();

        public BigDecimal call(BigDecimal arg1, BigDecimal arg2) {

            return arg1.divide(arg2);
        }

    }

    public static final class Remainder implements Function2<BigDecimal, BigDecimal, BigDecimal> {

        public static final Remainder INSTANCE = new Remainder();

        public BigDecimal call(BigDecimal arg1, BigDecimal arg2) {

            return arg1.remainder(arg2);
        }

    }

    public static final class Add implements Function2<BigDecimal, BigDecimal, BigDecimal> {

        public static final Add INSTANCE = new Add();

        public BigDecimal call(BigDecimal arg1, BigDecimal arg2) {

            return arg1.add(arg2);
        }

    }

    public static final class Subtract implements Function2<BigDecimal, BigDecimal, BigDecimal> {

        public static final Subtract INSTANCE = new Subtract();

        public BigDecimal call(BigDecimal arg1, BigDecimal arg2) {

            return arg1.subtract(arg2);
        }

    }

    public static Function1<BigDecimal, BigDecimal> negate_() {

        return Negate.INSTANCE;
    }

    public static Function2<BigDecimal, BigDecimal, BigDecimal> multiply_() {

        return Multiply.INSTANCE;
    }

    public static Function2<BigDecimal, BigDecimal, BigDecimal> divide_() {

        return Divide.INSTANCE;
    }

    public static Function2<BigDecimal, BigDecimal, BigDecimal> remainder_() {

        return Remainder.INSTANCE;
    }

    public static Function2<BigDecimal, BigDecimal, BigDecimal> add_() {

        return Add.INSTANCE;
    }

    public static Function2<BigDecimal, BigDecimal, BigDecimal> subtract_() {

        return Subtract.INSTANCE;
    }

}
