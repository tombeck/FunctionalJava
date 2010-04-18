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
package com.thomas.functional.collection.util.iterator;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 21.07.2007
 */
public class Iterators {

    public static final EmptyIterator<Object> EMPTY_ITERATOR = new EmptyIterator<Object>();
    public static final EmptyListIterator<Object> EMPTY_LIST_ITERATOR = new EmptyListIterator<Object>();
    
    @SuppressWarnings("unchecked")
    public static <E> Iterator<E> emptyIterator() {
    
        return (EmptyIterator<E>)EMPTY_ITERATOR;
    }
    
    @SuppressWarnings("unchecked")
    public static <E> ListIterator<E> emptyListIterator() {
    
        return (EmptyListIterator<E>)EMPTY_LIST_ITERATOR;
    }
    
    public static <E> LookAheadIterator<E> lookAheadIterator(Iterator<? extends E> base) {
        
        return new LookAheadIterator<E>(base);
    }
    
    public static <E> LookAheadListIterator<E> lookAheadListIterator(ListIterator<E> base) {
        
        return new LookAheadListIterator<E>(base);
    }
    
    public static <E> Iterator<E> singletonIterator(E element) {
        
        return new SingletonIterator<E>(element);
    }
    
    public static <E> ListIterator<E> singletonListIterator(E element) {
        
        return new SingletonListIterator<E>(element);
    }
    
    public static <E> Iterator<E> unmodifiableIterator(Iterator<? extends E> iter) {
        
        return new UnmodifiableIterator<E>(iter);
    }
    
    public static <E> ListIterator<E> unmodifiableListIterator(ListIterator<? extends E> iter) {
        
        return new UnmodifiableListIterator<E>(iter);
    }
    
    /**
     * TODO Method documentation
     * 
     * @param <T>
     * @param ret
     * @param count
     * @return
     * @author Thomas
     * @since 24.07.2008
     */
    public static <T, I extends Iterator<T>> I forward(I ret, int count) {

        for ( ; count > 0; --count) {
            ret.next();
        }
        
        return ret;
    }
    
    public static <T, I extends ListIterator<T>> I backward(I ret, int count) {

        for ( ; count > 0; --count) {
            ret.previous();
        }
        
        return ret;
    }
    
}
