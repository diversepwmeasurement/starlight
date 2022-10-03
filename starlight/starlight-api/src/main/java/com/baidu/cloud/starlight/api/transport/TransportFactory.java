/*
 * Copyright (c) 2019 Baidu, Inc. All Rights Reserved.
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
 
package com.baidu.cloud.starlight.api.transport;

import com.baidu.cloud.starlight.api.common.URI;

/**
 * SPI Factory of Transport, default is {@link StarlightTransportFactory} Created by liuruisen on 2020/1/16.
 */
public interface TransportFactory {

    /**
     * Get or Create ClientPeer by URI
     * 
     * @param uri ip + port + net config
     * @return
     */
    ClientPeer client(URI uri);

    /**
     * Get or Create ServerPeer by URI
     * 
     * @param uri ip + port + net config
     * @return
     */
    ServerPeer server(URI uri);
}
