<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<@pp.changeOutputFile name="Collections.java" />
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
package com.freiheit.jafp.collection;

import static com.freiheit.jafp.bind.Bind.asFunction1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.freiheit.jafp.bind.Arg;
<#list 1..max as i>
import com.freiheit.jafp.function.Function${i};
</#list>
import com.freiheit.jafp.functions.lang._Boolean;
import com.freiheit.jafp.functions.lang._Object;
<#list 1..max as i>
import com.freiheit.jafp.functions.tuple._Tuple${i};
</#list>
<#list 1..max as i>
import com.freiheit.jafp.tuple.Tuple${i};
</#list>

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 07.10.2006
 */
public final class Collections {

    public static <E> Collection<E> drop(Collection<E> c, int count) {
        
        return new DropCollection<E>(c, count);
    }
    
    public static <E> List<E> drop(List<E> c, int count) {
        
        return new DropList<E>(c, count);
    }
    
    public static <E> Collection<E> take(Collection<E> c, int count) {
        
        return new TakeCollection<E>(c, count);
    }
    
    public static <E> Collection<E> takeWhile(
    	Function1<? extends Boolean, ? super E> pred,
    	Collection<E> c) {
        
        return new TakeWhileCollection<E>(pred, c);
    }
    
    public static <E> List<E> take(List<E> c, int count) {
        
        return new TakeList<E>(c, count);
    }
    
    public static <E, T> E foldLeft(
            Collection<T> c,
            E init,
            Function2<? extends E, ? super E, ? super T> func) {
        
        for (T e : c) {
            init = func.call(init, e);
        }
        
        return init;
    }
    
    public static <E, T> E foldRight(
            Collection<T> c,
            E init,
            Function2<? extends E, ? super T, ? super E> func) {
        
        return foldRight(new ArrayList<T>(c), init, func);
    }
    
    public static <E, T> E foldRight(
            List<T> c,
            E init,
            Function2<? extends E, ? super T, ? super E> func) {
   
        
        for (T e : reverse(c)) {
            init = func.call(e, init);
        }
        
        return init;
    }
    
    public static List<Integer> range(int first, int last, int step) {
    
        return first < last ? new IntRange(first, last, step) : java.util.Collections.<Integer>emptyList();
    }
    
    public static List<Integer> range(int first, int last) {
        
        return range(first, last, 1);
    }
    
    public static List<Integer> range(int last) {
        
        return range(0, last);
    }
    
    public static <E> E reduceLeft(
            Collection<E> c,
            Function2<? extends E, ? super E, ? super E> func) {
        
        final Iterator<E> iter = c.iterator();
        
        E ret = null;
        
        if (iter.hasNext()) {
            ret = iter.next();
            while(iter.hasNext()) {
                ret = func.call(ret, iter.next());
            }
        }
            
        return ret;
    }
    
    public static <E> E reduceRight(
            Collection<E> c,
            Function2<? extends E, ? super E, ? super E> func) {
        
        return reduceRight(new ArrayList<E>(c), func);
    }
    
    public static <E> E reduceRight(
            List<E> c,
            Function2<? extends E, ? super E, ? super E> func) {
        
        final Iterator<E> iter = reverse(c).iterator();
        
        E ret = null;
        
        if (iter.hasNext()) {
            ret = iter.next();
            while(iter.hasNext()) {
                ret = func.call(iter.next(), ret);
            }
        }
            
        return ret;
    }
    
    public static <E, T> Collection<E> adjacentPair(
            Function2<? extends E, ? super T, ? super T> func,
            Collection<T> c) {
    
        return new AdjacentPairCollection<E, T>(func, c);
    }

    public static <E> Collection<Tuple2<E, E>> adjacentPair(Collection<? extends E> c) {
        
        return adjacentPair(_Tuple2.<E, E>tuple2_(), c);
    }

    public static <E> Collection<E> concat(
            Collection<? extends E> c1,
            Collection<? extends E> c2) {
    
        return new ConcatCollection<E>(c1, c2);
    }
    
    public static <E> List<E> concat(List<? extends E> l1, List<? extends E> l2) {
        
        return new ConcatList<E>(l1, l2);
    }

    public static <E> Collection<E> retain(Object element, Collection<E> c) {
        
        return retainIf(
                asFunction1(_Object.nullSafeEquals_()).bind(
                        Arg.$1(), Arg.$(element)),
                c);
    }
    
    public static <E> List<E> retain(Object element, List<E> c) {
        
        return retainIf(
                asFunction1(_Object.nullSafeEquals_()).bind(
                        Arg.$1(), Arg.$(element)),
                c);
    }
    
    public static <E> Collection<E> retainIf(
            Function1<? extends Boolean, ? super E> pred,
            Collection<? extends E> c) {
        
        return new FilterCollection<E>(pred, c);
    }
    
    public static <E> List<E> retainIf(
            Function1<? extends Boolean, ? super E> pred,
            List<? extends E> c) {
        
        return new FilterList<E>(pred, c);
    }
    
    public static <E> Collection<E> removeIf(
            Function1<? extends Boolean, ? super E> pred,
            Collection<? extends E> c) {
        
        return retainIf(asFunction1(_Boolean.not_()).bind(pred), c);
    }
    
    public static <E> List<E> removeIf(
            Function1<? extends Boolean, ? super E> pred,
            List<? extends E> c) {
        
        return retainIf(asFunction1(_Boolean.not_()).bind(pred), c);
    }
    
    public static <E> Collection<E> remove(Object element, Collection<E> c) {
        
        return removeIf(
                asFunction1(_Object.nullSafeEquals_()).bind(
                        Arg.$1(), Arg.$(element)),
                c);
    }
    
    public static <E> List<E> remove(Object element, List<E> c) {
        
        return removeIf(
                asFunction1(_Object.nullSafeEquals_()).bind(
                        Arg.$1(), Arg.$(element)),
                c);
    }
    
<#list 2..max as i>
    public static <E, <@csv 1..i; j>T${j}</@csv>> Collection<E> join(
            Function${i}<? extends E, <@csv 1..i; j>? super T${j}</@csv>> func,<@csv 1..i; j>
            Collection<T${j}> c${j}</@csv>) {
        
        return new Join${i}Collection<E, <@csv 1..i; j>T${j}</@csv>>(func, <@csv 1..i; j>c${j}</@csv>);
    }
    
</#list>
<#list 2..max as i>
    public static <<@csv 1..i; j>E${j}</@csv>> Collection<Tuple${i}<<@csv 1..i; j>E${j}</@csv>>> join(<@csv 1..i; j>
	        Collection<E${j}> c${j}</@csv>) {
	    
	    return join(_Tuple${i}.<<@csv 1..i; j>E${j}</@csv>>tuple${i}_(), <@csv 1..i; j>c${j}</@csv>);
	}

</#list>
    public static <E> Collection<E> merge(
            Function2<? extends Boolean, ? super E, ? super E> less,
            Collection<? extends E> base1,
            Collection<? extends E> base2) {
        
        return new MergeCollection<E>(less, base1, base2);
    }
    
    public static <E> List<E> merge(
            Function2<? extends Boolean, ? super E, ? super E> less,
            List<? extends E> base1,
            List<? extends E> base2) {
        
        return new MergeList<E>(less, base1, base2);
    }
    
    public static <E> List<E> reverse(List<E> l) {
    
        return new ReverseList<E>(l);
    }
    
    public static <E> List<E> rotate(int index, List<E> l) {
    
        return new RotateList<E>(index, l);
    }
    
<#list 1..max as i>
    public static <E, <@csv 1..i; j>T${j}</@csv>> Collection<E> map(
            Function${i}<? extends E, <@csv 1..i; j>? super T${j}</@csv>> func,<@csv 1..i; j>
            Collection<T${j}> c${j}</@csv>) {
        
        return new Transform${i}Collection<E, <@csv 1..i; j>T${j}</@csv>>(func, <@csv 1..i; j>c${j}</@csv>);
    }
    
</#list>
<#list 1..max as i>
    public static <E, <@csv 1..i; j>T${j}</@csv>> List<E> map(
            Function${i}<? extends E, <@csv 1..i; j>? super T${j}</@csv>> func,<@csv 1..i; j>
            List<T${j}> c${j}</@csv>) {
        
        return new Transform${i}List<E, <@csv 1..i; j>T${j}</@csv>>(func, <@csv 1..i; j>c${j}</@csv>);
    }
    
</#list>
    public static <E> Collection<E> unique(
            Function2<? extends Boolean, ? super E, ? super E> equal,
            Collection<E> base) {
        
        return new UniqueCollection<E>(equal, base);
    }
    
<#list 1..max as i>
    public static <<@csv 1..i; j>T${j}</@csv>> Collection<Tuple${i}<<@csv 1..i; j>T${j}</@csv>>> zip(<@csv 1..i; j>
            Collection<? extends T${j}> c${j}</@csv>) {
        
        return map(_Tuple${i}.<<@csv 1..i; j>T${j}</@csv>>tuple${i}_(), <@csv 1..i; j>c${j}</@csv>);
    }

</#list>
<#list 1..max as i>
    public static <<@csv 1..i; j>T${j}</@csv>> List<Tuple${i}<<@csv 1..i; j>T${j}</@csv>>> zip(<@csv 1..i; j>
            List<? extends T${j}> c${j}</@csv>) {
        
        return map(_Tuple${i}.<<@csv 1..i; j>T${j}</@csv>>tuple${i}_(), <@csv 1..i; j>c${j}</@csv>);
    }

</#list>
}
