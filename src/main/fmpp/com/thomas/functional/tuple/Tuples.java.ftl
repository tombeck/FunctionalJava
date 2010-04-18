<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<@pp.changeOutputFile name="Tuples.java" />
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

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 05.10.2006
 */
public class Tuples {

    /**
     * Private constructor since it is a utility class.
     * 
     * @author Thomas
     * @since 28.03.2009
     */
    private Tuples() {

        //intentionally left empty 
    }

<#list 1..max as i>
    public static <<@csv 1..i; j>S${j}</@csv>> Tuple${i}<<@csv 1..i; j>S${j}</@csv>> asTuple(<@csv 1..i; j>S${j} arg${j}</@csv>) {

        return new Tuple${i}<<@csv 1..i; j>S${j}</@csv>>(<@csv 1..i; j>arg${j}</@csv>);
    }
    
    public static <<@csv 1..i; j>S${j}</@csv>> Tuple${i}<<@csv 1..i; j>S${j}</@csv>> asTuple${i}(AtLeastTuple${i}<<@csv 1..i; j>S${j}</@csv>> other) {
        
        return new Tuple${i}<<@csv 1..i; j>S${j}</@csv>>(other);
    }
    
    public static <T> Tuple${i}<<@csv 1..i; j>T</@csv>> asTuple${i}(T[] other) {
        
        final Tuple${i}<<@csv 1..i; j>T</@csv>> ret = new Tuple${i}<<@csv 1..i; j>T</@csv>>();
        
<#list 1..i as j>
        ret.setArg${j}(other[${j-1}]);
</#list>
        
        return ret;
    }
    
<#if i = 2>
    public static <S1, S2> Pair<S1, S2> asPair(S1 arg1, S2 arg2) {

        return new Pair<S1, S2>(arg1, arg2);
    }

    public static <S1, S2> Pair<S1, S2> asPair(AtLeastTuple2<S1, S2> other) {
    
        return new Pair<S1, S2>(other);
    }
    
</#if>
</#list>    
}
