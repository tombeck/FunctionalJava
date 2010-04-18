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

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 05.01.2007
 */
public final class _Number {

    public static final class ByteValue_ implements Function1<Byte, Number> {

        public static final ByteValue_ INSTANCE = new ByteValue_();

        public Byte call(Number arg1) {

            return arg1.byteValue();
        }

    }

    public static final class DoubleValue_ implements Function1<Double, Number> {

        public static final DoubleValue_ INSTANCE = new DoubleValue_();

        public Double call(Number arg1) {

            return arg1.doubleValue();
        }

    }

    public static final class FloatValue_ implements Function1<Float, Number> {

        public static final FloatValue_ INSTANCE = new FloatValue_();

        public Float call(Number arg1) {

            return arg1.floatValue();
        }

    }

    public static final class IntValue_ implements Function1<Integer, Number> {

        public static final IntValue_ INSTANCE = new IntValue_();

        public Integer call(Number arg1) {

            return arg1.intValue();
        }

    }

    public static final class LongValue_ implements Function1<Long, Number> {

        public static final LongValue_ INSTANCE = new LongValue_();

        public Long call(Number arg1) {

            return arg1.longValue();
        }

    }

    public static final class ShortValue_ implements Function1<Short, Number> {

        public static final ShortValue_ INSTANCE = new ShortValue_();

        public Short call(Number arg1) {

            return arg1.shortValue();
        }

    }

    public static Function1<Byte, Number> byteValue_() {

        return ByteValue_.INSTANCE;
    }

    public static Function1<Double, Number> doubleValue_() {

        return DoubleValue_.INSTANCE;
    }

    public static Function1<Float, Number> floatValue_() {

        return FloatValue_.INSTANCE;
    }

    public static Function1<Integer, Number> intValue_() {

        return IntValue_.INSTANCE;
    }

    public static Function1<Long, Number> longValue_() {

        return LongValue_.INSTANCE;
    }

    public static Function1<Short, Number> shortValue_() {

        return ShortValue_.INSTANCE;
    }

}
