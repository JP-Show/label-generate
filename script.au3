#include <Process.au3>
#include <MsgBoxConstants.au3>
#include <Date.au3>
#RequireAdmin
;MsgBox($MB_SYSTEMMODAL, "", "start  """" """ & @WorkingDir & "\aida64extreme633\aida64extreme633\aida64.exe""")
Do
	_RunDos("start  """" """ & @WorkingDir & "\aida64extreme633\aida64extreme633\aida64.exe""")
	WinWaitActive("AIDA64 Extreme")
	Send("!ra")
	Sleep(1000)
	Send("!phptf")
	; sleep 3s.
	Sleep(3000)
Until WinActive("Relatório - AIDA64")

While Not WinActive("Salvar Relatório")
	WinActivate("Relatório - AIDA64")
	send("!aa")
	; sleep 5s.s
	Sleep(5000)
	WinActivate("Salvar Relatório")
WEnd

WinActivate("Salvar Relatório")
Local $date, $date2
_DateTimeSplit(_NowDate(), $date, $date2)
Local $y = $date[3]
Local $m = $date[2]
Local $d = $date[1]

WinActivate("Salvar Relatório")
Local $hWnd = WinWaitActive("Salvar Relatório")
Local $control1 = ControlGetHandle($hWnd, "", "[CLASS:ToolbarWindow32; INSTANCE:4]")
Local $control2 = ControlGetHandle($hWnd, "", "[CLASS:Edit; INSTANCE:1]")
Send("^l")
Send(@WorkingDir)
Sleep(2000)
Send("{ENTER}")
WinActivate("Salvar Relatório")
ControlClick($hWnd, "", $control2)
send("Relatório de hardware " & $d & "-" & $m & "-" & $y & ".txt")
Sleep(2000)
Send("{ENTER}")
send("!l")
Sleep(2000)
run("exec.bat")
