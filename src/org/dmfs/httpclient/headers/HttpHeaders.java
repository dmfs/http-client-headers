/*
 * Copyright (C) 2016 Marten Gajda <marten@dmfs.org>
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dmfs.httpclient.headers;

import org.dmfs.httpclient.converters.LinkConverter;
import org.dmfs.httpclient.converters.MediaTypeConverter;
import org.dmfs.httpclient.converters.QuotedStringConverter;
import org.dmfs.httpclient.types.Link;
import org.dmfs.httpclient.types.MediaType;


/**
 * Defines {@link HeaderType}s for well known standard headers.
 * 
 * @author Marten Gajda <marten@dmfs.org>
 */
public interface HttpHeaders
{
	/**
	 * The content-type header that contains the media-type of the response entity.
	 */
	public final static SimpleHeaderType<MediaType> CONTENT_TYPE = new BasicHeaderType<MediaType>("content-type", MediaTypeConverter.INSTANCE);

	/**
	 * The Link header that contains links to documents related to the response.
	 */
	public final static ListHeaderType<Link> LINK = new BasicListHeaderType<Link>("link", new LinkConverter());

	/**
	 * The accept-encoding header that contains the content-encoding of the response entity.
	 */
	public final static ListHeaderType<String> ACCEPT_ENCODING = new BasicListHeaderType<String>("accept-encoding", QuotedStringConverter.INSTANCE);

	/**
	 * The content-encoding header that contains the content encoding of the response entity.
	 */
	public final static ListHeaderType<String> CONTENT_ENCODING = new BasicListHeaderType<String>("content-encoding", QuotedStringConverter.INSTANCE);

}
