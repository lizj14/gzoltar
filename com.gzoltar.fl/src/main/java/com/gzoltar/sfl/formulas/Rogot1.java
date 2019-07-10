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
package com.gzoltar.sfl.formulas;

public final class Rogot1 extends AbstractSFLFormula {
    @Override
    public String getName() {
        return "Rogot1";
    }

    @Override
    public double compute(final double n00, final double n01, final double n10, final double n11) {
        double nFailed = n11 + n11 + n01 + n10 == 0 ? 0 : n11/(2*(n11 + n11 + n01 + n10));
        double nPassed = n01 + n00 + n00 + n10 == 0 ? 0 : n00/(2*(n01 + n00 + n00 + n10));

        return nPassed + nFailed;
    }
}
