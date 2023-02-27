cmake_minimum_required(VERSION 3.5)

# CXX is required for linking heaps.hdll
project(heapsapp C CXX)

# set up hashlink options
option(BUILD_SHARED_LIBS OFF)
option(BUILD_TESTING OFF)
option(WITH_VM OFF)

add_subdirectory(hashlink)

target_compile_definitions(libhl PRIVATE HL_ANDROID_ACTIVITY="io/heaps/android/HeapsActivity")

add_library(heapsapp SHARED out/main.c)

target_include_directories(heapsapp PRIVATE out hashlink/src)

target_link_libraries(heapsapp
	# force JNI_OnLoad to be included from libhl.a
	"-Wl,--undefined=JNI_OnLoad" libhl
	sdl.hdll fmt.hdll openal.hdll ui.hdll uv.hdll heaps.hdll
)
