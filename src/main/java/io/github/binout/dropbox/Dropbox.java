/*
 * Copyright 2016 Benoît Prioux
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.binout.dropbox;


import feign.Feign;
import feign.Headers;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import io.github.binout.dropbox.model.Account;
import io.github.binout.dropbox.model.FolderList;
import io.github.binout.dropbox.model.Path;

public interface Dropbox {

    @RequestLine("POST /files/list_folder")
    @Headers("Content-Type: application/json")
    FolderList listFolder(Path path);

    @RequestLine("POST /users/get_current_account")
    Account currentAccount();

    static String apiKey() {
        return System.getProperty("dropbox.api.key");
    }

    static Dropbox api() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .requestInterceptor(r -> r.header("Authorization", "Bearer " + apiKey()))
                .target(Dropbox.class, "https://api.dropboxapi.com/2");
    }
}
