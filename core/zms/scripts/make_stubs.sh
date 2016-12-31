#!/bin/bash

# If any of the RDL files have been updated, then this script should be run
# rdl to generate the appropriate model classes.

# Note this script is dependent on the rdl utility.
# go get github.com/ardielle/ardielle-tools/...
#

command -v rdl >/dev/null 2>&1 || {
    echo >&2 "------------------------------------------------------------------------";
    echo >&2 "SOURCE WARNING";
    echo >&2 "------------------------------------------------------------------------";
    echo >&2 "Please install rdl utility: go get github.com/ardielle/ardielle-tools/...";
    echo >&2 "Skipping source generation...";
    exit 0;
}

RDL_ZMS_FILE=src/main/rdl/ZMS.rdl
RDL_PROVIDER_FILE=src/main/rdl/Provider.rdl

echo "Generating model classes..."
rdl -s generate -x getsetters=true -o src/main/java java-model $RDL_ZMS_FILE
rdl -s generate -x getsetters=true -o src/main/java java-model $RDL_PROVIDER_FILE

# Copyright 2016 Yahoo Inc.
# Licensed under the terms of the Apache version 2.0 license. See LICENSE file for terms.
