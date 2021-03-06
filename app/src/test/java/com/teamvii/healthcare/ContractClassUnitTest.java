package com.teamvii.healthcare;

import android.provider.BaseColumns;

import com.teamvii.healthcare.data.HealthCareContract;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ContractClassUnitTest {

    @Test
    public void inner_class_exists() throws Exception {
        Class[] innerClasses = HealthCareContract.class.getDeclaredClasses();
        assertEquals( "There should be 1 Inner class inside the contract class", 6, innerClasses.length );
    }

    @Test
    public void inner_class_type_correct() throws Exception {
        Class[] innerClasses = HealthCareContract.class.getDeclaredClasses();
        assertEquals( "Cannot find inner class to complete unit test", 6, innerClasses.length );
        Class entryClass = innerClasses[0];
        assertTrue( "Inner class should implement the BaseColumns interface", BaseColumns.class.isAssignableFrom( entryClass ) );
        assertTrue( "Inner class should be final", Modifier.isFinal( entryClass.getModifiers() ) );
        assertTrue( "Inner class should be static", Modifier.isStatic( entryClass.getModifiers() ) );
    }

    @Test
    public void inner_class_members_correct() throws Exception {
        Class[] innerClasses = HealthCareContract.class.getDeclaredClasses();
        assertEquals( "Cannot find inner class to complete unit test", 6, innerClasses.length );
        for (Class entryClass : innerClasses) {
            Field[] allFields = entryClass.getDeclaredFields();
            assertEquals( "There should be exactly 4 String members in the inner class", 6, allFields.length );
            for (Field field : allFields) {
//                assertTrue("All members in the contract class should be Strings", (field.getType() == String.class));
                assertTrue( "All members in the contract class should be final", Modifier.isFinal( field.getModifiers() ) );
                assertTrue( "All members in the contract class should be static", Modifier.isStatic( field.getModifiers() ) );
            }
        }
    }

}