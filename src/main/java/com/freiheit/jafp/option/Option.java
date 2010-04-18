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
package com.freiheit.jafp.option;

import static com.freiheit.jafp.option.None.NONE;

import java.util.AbstractCollection;

import com.freiheit.jafp.function.Function0;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 30.12.2009
 */
public abstract class Option<T> extends AbstractCollection<T> {

    public static <S> Option<S> some(S value) {
    
        return new Some<S>(value);
    }
    
    @SuppressWarnings("unchecked")
    public static <S> Option<S> none() {
        
        return (Option<S>)NONE;
    }

    public abstract boolean isDefined();
    
    public abstract T get();
    
    public abstract T getOrElse(Function0<? extends T> alt);
    
    Option() { /**/ }
    
}
