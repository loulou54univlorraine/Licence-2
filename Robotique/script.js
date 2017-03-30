var __interpretation_started_timestamp__;
var pi = 3.141592653589793;

var main = function()
{
	__interpretation_started_timestamp__ = Date.now();
	var i=0;
	while (i<3) {
		i=i+1;
		brick.motor(M1).setPower(100);
		brick.motor(M2).setPower(100);
		
		script.wait(3300);
		
		brick.motor(M1).setPower(-(100));
		brick.motor(M2).setPower(-(100));
		
		script.wait(3300);
		
		brick.motor(M1).setPower(100);
		
		brick.motor(M2).setPower(-(100));
		
		script.wait(510);
		
		brick.motor(M1).setPower(100);
		brick.motor(M2).setPower(100);
		
		script.wait(1300);
		
		brick.motor(M2).setPower(100);
		
		brick.motor(M1).setPower(-(100));
		
		script.wait(510);
		
	}
}
