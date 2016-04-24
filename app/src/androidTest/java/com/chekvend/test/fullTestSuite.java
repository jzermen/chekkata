package com.chekvend.test;

import android.test.suitebuilder.TestSuiteBuilder;

public class fullTestSuite {
    public static TestSuiteBuilder suite() {
        return new TestSuiteBuilder(fullTestSuite.class).includeAllPackagesUnderHere();
    }

    public fullTestSuite() {
        super();
    }
}
