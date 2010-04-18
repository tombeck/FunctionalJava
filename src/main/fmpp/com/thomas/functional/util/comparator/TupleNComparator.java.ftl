<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<#list 1..max as i>
<@pp.changeOutputFile name="Tuple" + i + "Comparator.java" />
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
package com.thomas.functional.util.comparator;

import java.util.Comparator;

import com.thomas.functional.tuple.AtLeastTuple${i};

/**
 * TODO Type documentation
 *
 * @author Thomas
 * @since 03.06.2007
 */
public class Tuple${i}Comparator<<@csv 1..i; j>T${j}</@csv>>
    implements Comparator<AtLeastTuple${i}<<@csv 1..i; j>? extends T${j}</@csv>>>{

<#list 1..i as j>
    private final Comparator<? super T${j}> comp${j};
</#list>
    
    public Tuple${i}Comparator(<@csv 1..i; j>Comparator<? super T${j}> comp${j}</@csv>) {
        
<#list 1..i as j>
        if (comp${j} == null) throw new NullPointerException();
</#list>

<#list 1..i as j>
        this.comp${j} = comp${j};
</#list>
    }
    
    public int compare(AtLeastTuple${i}<<@csv 1..i; j>? extends T${j}</@csv>> o1, AtLeastTuple${i}<<@csv 1..i; j>? extends T${j}</@csv>> o2) {

        int ret = 0;
        
<#list 1..i as j>
        if (ret == 0) ret = this.comp${j}.compare(o1.getArg${j}(), o2.getArg${j}());
</#list>

        return ret;
    }

}
</#list>
