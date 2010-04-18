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
package com.freiheit.jafp.functions.lang;

import com.freiheit.jafp.function.Function1;
import com.freiheit.jafp.function.Function2;
import com.freiheit.jafp.predicate.Predicate2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 05.01.2007
 */
public final class _String {

    public static final class Concat_ implements Function2<String, String, String> {

        public static final Concat_ INSTANCE = new Concat_();

        public String call(String arg1, String arg2) {

            return arg1.concat(arg2);
        }

    }

    public static final class Contains_ extends Predicate2<String, CharSequence> {

        public static final Contains_ INSTANCE = new Contains_();

        @Override
        public boolean appliesTo(String arg1, CharSequence arg2) {

            return arg1.contains(arg2);
        }

    }

    public static final class EqualsIgnoreCase_ extends Predicate2<String, String> {

        public static final EqualsIgnoreCase_ INSTANCE = new EqualsIgnoreCase_();

        @Override
        public boolean appliesTo(String arg1, String arg2) {

            return arg1.equalsIgnoreCase(arg2);
        }

    }

    public static final class Matches_ extends Predicate2<String, String> {

        public static final Matches_ INSTANCE = new Matches_();

        @Override
        public boolean appliesTo(String arg1, String arg2) {

            return arg1.matches(arg2);
        }

    }

    public static final class Trim_ implements Function1<String, String> {

        public static final Trim_ INSTANCE = new Trim_();

        public String call(String arg1) {

            return arg1.trim();
        }

    }

    public static <T> Function2<String, String, String> concat_() {

        return Concat_.INSTANCE;
    }

    public static <T> Predicate2<String, CharSequence> contains_() {

        return Contains_.INSTANCE;
    }

    public static <T> Predicate2<String, String> equalsIgnoreCase_() {

        return EqualsIgnoreCase_.INSTANCE;
    }

    public static <T> Predicate2<String, String> matches_() {

        return Matches_.INSTANCE;
    }

    public static <T> Function1<String, String> trim_() {

        return Trim_.INSTANCE;
    }

}
