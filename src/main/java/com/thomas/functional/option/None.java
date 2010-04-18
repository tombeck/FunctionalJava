/**
 * $Id$
 *
 * Copyright (c) 2009 Thomas Beckmann 
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
package com.thomas.functional.option;

import static com.thomas.functional.collection.util.iterator.Iterators.emptyIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.thomas.functional.function.Function0;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 30.12.2009
 */
final class None<T> extends Option<T> {

    public static final Option<Object> NONE = new None<Object>();

    private None() { 
        
        // non-static singleton
    }

    @Override
    public boolean isDefined() {

        return false;
    }

    @Override
    public T get() {

        throw new NoSuchElementException();
    }

    @Override
    public Iterator<T> iterator() {

        return emptyIterator();
    }

    @Override
    public boolean isEmpty() {

        return true;
    }

    @Override
    public int size() {

        return 0;
    }

    @Override
    public T getOrElse(Function0<? extends T> alt) {

        return alt.call();
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public boolean equals(Object obj) {

        return this == obj;
    }

    @Override
    public String toString() {
        
        return "None";
    }
    
}
