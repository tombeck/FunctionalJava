/**
 * $Id$
 *
 * Copyright (c) 2006 Thomas Beckmann 
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
package com.thomas.functional.tuple;

import com.thomas.functional.tuple.AtLeastTuple2;
import com.thomas.functional.tuple.Tuple2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 03.03.2006
 */
public class Pair<T1, T2> extends Tuple2<T1, T2> {

    private static final long serialVersionUID = 6729423338617692051L;

    public Pair() {

        super();
    }

    public Pair(T1 arg1, T2 arg2) {

        super(arg1, arg2);
    }

    public Pair(AtLeastTuple2<? extends T1, ? extends T2> source) {

        super(source);
    }

    public T1 getFirst() {

        return getArg1();
    }

    public void setFirst(T1 arg1) {

        setArg1(arg1);
    }

    public T2 getSecond() {

        return getArg2();
    }

    public void setSecond(T2 arg2) {

        setArg2(arg2);
    }

}
