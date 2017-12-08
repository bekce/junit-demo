package com.sebworks.junitdemo;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitDemoApplicationTests {

	@Test
	public void subRunner() throws Exception {
		System.err.println("--------------------------------");
		System.err.println("MainTest subRunner()");
		System.err.println("--------------------------------");
		JUnitCore.runClasses(SubTestWithRunner.class);
	}

	@RunWith(MockitoJUnitRunner.StrictStubs.class)
    public static class SubTestWithRunner {

        @Mock
        private List<Integer> list;

        @BeforeClass
        public static void init() throws Exception {
            System.err.println("--------------------------------");
            System.err.println("SubTestWithRunner init()");
            System.err.println("--------------------------------");
        }

        @Test
        public void test1(){
            System.err.println("--------------------------------");
            System.err.println("SubTestWithRunner test()");
            list.add(100);
            System.err.println("--------------------------------");
        }
    }
}
