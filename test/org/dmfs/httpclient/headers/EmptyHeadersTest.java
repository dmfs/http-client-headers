package org.dmfs.httpclient.headers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.dmfs.httpclient.types.StringMediaType;
import org.junit.Test;


public class EmptyHeadersTest
{

	@Test
	public void testIterator()
	{
		assertFalse(new EmptyHeaders().iterator().hasNext());
	}


	@Test
	public void testContains()
	{
		assertFalse(new EmptyHeaders().contains(HttpHeaders.CONTENT_TYPE));
	}


	@Test(expected = NoSuchElementException.class)
	public void testHeaderSingletonHeaderTypeOfT()
	{
		new EmptyHeaders().header(HttpHeaders.CONTENT_TYPE);
	}


	@Test(expected = NoSuchElementException.class)
	public void testHeaderListHeaderTypeOfT()
	{
		new EmptyHeaders().header(HttpHeaders.LINK);
	}


	@Test
	public void testWithHeader()
	{
		assertTrue(new EmptyHeaders().withHeader(HttpHeaders.CONTENT_TYPE.entity(new StringMediaType("application/binary"))).contains(HttpHeaders.CONTENT_TYPE));
		assertEquals(new StringMediaType("application/binary"),
			new EmptyHeaders().withHeader(HttpHeaders.CONTENT_TYPE.entity(new StringMediaType("application/binary"))).header(HttpHeaders.CONTENT_TYPE).value());
	}


	@Test
	public void testWithoutHeaderType()
	{
		assertFalse(new EmptyHeaders().withoutHeaderType(HttpHeaders.CONTENT_TYPE).contains(HttpHeaders.CONTENT_TYPE));
	}

}
