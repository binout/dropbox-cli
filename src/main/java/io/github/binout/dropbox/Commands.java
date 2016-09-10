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

import io.github.binout.dropbox.model.Folder;
import io.github.binout.dropbox.model.Path;
import org.tomitribe.crest.api.Command;
import org.tomitribe.crest.api.Default;
import org.tomitribe.crest.api.Option;

import java.util.stream.Collectors;

public class Commands {

    private final static Dropbox API = Dropbox.api();

    @Command
    public String whoami() {
        return API.currentAccount().getName().getDisplayName();
    }

    @Command
    public String ls(@Option("path") @Default("") Path path) {
        return API.listFolder(path).stream().map(Folder::getName).collect(Collectors.joining(System.lineSeparator()));
    }

    @Command
    public void mkdir(Path path) {
        API.createFolder(path);
    }
}
