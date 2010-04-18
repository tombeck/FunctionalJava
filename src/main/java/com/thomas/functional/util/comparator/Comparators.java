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
package com.thomas.functional.util.comparator;

import java.util.Comparator;

import com.thomas.functional.function.Function2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 12.12.2009
 */
public class Comparators {

    public static <T> Comparator<T> chainedComparator(Comparator<? super T>... comparators) {
    
        return new ChainedComparator<T>(comparators);
    }
    
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> Comparator<T> comparableComparator() {
        
        return (ComparableComparator<T>)COMPARABLE_COMPARATOR;
    }
    
    public static <T> LessComparator<T> lessComparator(Function2<? extends Boolean, ? super T, ? super T> less) {
        
        return new LessComparator<T>(less);
    }
    
    public static <T> LexicographicalComparator<T> lexicographicalComparator(Comparator<? super T> comp) {
        
        return new LexicographicalComparator<T>(comp);
    }
    
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> LexicographicalComparator<T> lexicographicalComparator() {
        
        return (LexicographicalComparator<T>)LEXICOGRAPHICAL_COMPARATOR;
    }
    
    public static <T> Comparator<T> nullComparator(Comparator<? super T> comp, boolean nullIsLess) {
    
        return new NullComparator<T>(comp, nullIsLess);
    }
    
    private static final ComparableComparator<Comparable<Comparable<?>>> COMPARABLE_COMPARATOR = new ComparableComparator<Comparable<Comparable<?>>>();
    private static final LexicographicalComparator<Comparable<Comparable<?>>> LEXICOGRAPHICAL_COMPARATOR = new LexicographicalComparator<Comparable<Comparable<?>>>(COMPARABLE_COMPARATOR);
    
    private Comparators() {
    
        // utility class
    }
    
}
