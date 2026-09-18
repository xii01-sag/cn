set ns [new Simulator]

set nf [open prgm1.nam w]
$ns namtrace-all $nf

set nd [open prgm1.tr w]
$ns trace-all $nd

proc finish {} {
    global ns nd nf
    $ns flush-trace
    close $nf
    close $nd
    exec nam prgm1.nam &
    exit 0
}

set n0 [$ns node]
set n1 [$ns node]

$ns duplex-link $n0 $n1 1Mb 10ms DropTail

$ns at 0.5 "finish"

$ns run
