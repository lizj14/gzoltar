/**
 * Copyright (C) 2018 GZoltar contributors.
 * 
 * This file is part of GZoltar.
 * 
 * GZoltar is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * 
 * GZoltar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with GZoltar. If
 * not, see <https://www.gnu.org/licenses/>.
 */
package com.gzoltar.core.instr.matchers;

import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtField;

public class DuplicateMatcher implements IMatcher {

  private final String methodNameMatcher;

  private final String fieldNameMatcher;

  public DuplicateMatcher(final String methodNameMatcher, final String fieldNameMatcher) {
    this.methodNameMatcher = methodNameMatcher;
    this.fieldNameMatcher = fieldNameMatcher;
  }

  @Override
  public boolean matches(final CtClass ctClass) {
    for (CtBehavior ctBehavior : ctClass.getDeclaredBehaviors()) {
      if (this.matches(ctBehavior)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean matches(final CtBehavior ctBehavior) {
    if (this.methodNameMatcher == null) {
      return false;
    }
    return ctBehavior.getName().equals(this.methodNameMatcher);
  }

  @Override
  public boolean matches(final CtField ctField) {
    if (this.fieldNameMatcher == null) {
      return false;
    }
    return ctField.getName().equals(this.fieldNameMatcher);
  }

}
