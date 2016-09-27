#!/bin/bash
echo "Launching Dropbox CLI"
java -Ddropbox.api.key=$DROPBOX_API_KEY -jar target/dropbox-cli.jar