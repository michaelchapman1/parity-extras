#!/bin/bash
cd "$(dirname "$0")"
java -jar parity-sim.jar etc/devel.conf 2>&1 | tee parity-sim.log


