#!/usr/bin/env bash

PRG="$0"

while [ -h "$PRG" ] ; do
  ls=`ls -ld "$PRG"`
  link=`expr "$ls" : '.*-> \(.*\)$'`
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG=`dirname "$PRG"`/"$link"
  fi
done

base_dir=`dirname "$PRG"`/..
base_dir=`cd "$base_dir" && pwd`
bin_dir=${base_dir}/bin
lib_dir=${base_dir}/lib
conf_dir=${base_dir}/conf
CLASS_PATH=${conf_dir}:$(ls ${lib_dir}/*.jar | tr '\n' :)

mainclass="me.tunzao.assembly.demo.Hello"

cd ${base_dir}
java  -cp ${CLASS_PATH} ${mainclass}
