<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<#list 0..max as i>
<@pp.changeOutputFile name="Predicate" + i + ".java" />
/**
 * $Id$
 *
 * Copyright (c) 2005 Thomas Beckmann 
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
package com.thomas.functional.predicate;

import com.thomas.functional.function.Function${i};

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 15.10.2005
 */
<#if i = 0>
public abstract class Predicate0 implements Function0<Boolean> {

    public abstract boolean applies();

    public final Boolean call() {

        return applies();
    }

}
<#else>
public abstract class Predicate${i}<<@csv 1..i; j>T${j}</@csv>>
    implements Function${i}<Boolean, <@csv 1..i; j>T${j}</@csv>> {

    public abstract boolean appliesTo(<@csv 1..i; j>T${j} arg${j}</@csv>);

    public final Boolean call(<@csv 1..i; j>T${j} arg${j}</@csv>) {

        return appliesTo(<@csv 1..i; j>arg${j}</@csv>);
    }

}
</#if>
</#list>
