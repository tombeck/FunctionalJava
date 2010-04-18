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

import static com.thomas.functional.collection.util.iterator.Iterators.singletonIterator;

import java.util.Iterator;

import com.thomas.functional.function.Function0;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 30.12.2009
 */
public class Some<S> extends Option<S> {

    private final S value;

    Some(S value) {

        if (value == null) throw new NullPointerException("Value of some must not be null");
        
        this.value = value;
    }

    @Override
    public boolean isDefined() {

        return true;
    }

    @Override
    public S get() {

        return this.value;
    }

    @Override
    public Iterator<S> iterator() {

        return singletonIterator(this.value);
    }

    @Override
    public boolean isEmpty() {

        return false;
    }

    @Override
    public int size() {

        return 1;
    }

    @Override
    public S getOrElse(Function0<? extends S> alt) {

        return this.value;
    }

    @Override
    public int hashCode() {

        return 31 + this.value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (!(obj instanceof Some<?>)) return false;

        final Some<?> other = (Some<?>)obj;

        return this.value.equals(other.value);
    }

    @Override
    public String toString() {
        
        return "Some[" + this.value + "]";
    }
    
}
