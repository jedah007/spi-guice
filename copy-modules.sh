#!/usr/bin/env bash

function copy-jar {
    cp modules/$1/target/$1-1.0.jar my-modules
}

copy-jar m1
copy-jar m2
