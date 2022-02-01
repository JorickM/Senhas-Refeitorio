<?php

namespace App\Http\Controllers;

use App\Models\Weekday;
use Illuminate\Http\Request;
use WeakMap;

class WeekdayController extends Controller
{
  /**
   * Display a listing of the resource.
   *
   * @return \Illuminate\Http\Response
   */
  public function index()
  {
    $weekdays = Weekday::all();
    return view('weekdays.list', compact('weekdays', 'weekdays'));
  }

  public function getAllWeekdays()
  {
    $weekday = Weekday::get()->toJson(JSON_PRETTY_PRINT);
    return response($weekday, 200);
  }

  /**
   * Show the form for creating a new resource.
   *
   * @return \Illuminate\Http\Response
   */
  public function create()
  {
    return view('weekdays.create');
  }


  /**
   * Store a newly created resource in storage.
   *
   * @param  \Illuminate\Http\Request  $request
   * @return \Illuminate\Http\Response
   */
  public function store(Request $request)
  {
    $request->validate([
      'txtName' => 'required',
      'txtDate' => 'required'
    ]);

    $weekday = new Weekday([
      'name' => $request->get('txtName'),
      'date' => $request->get('txtDate')
    ]);

    $weekday->save();
    return redirect('/weekdays')->with('success', 'Weekday has been added');
  }

  /**
   * Display the specified resource.
   *
   * @param  \App\Models\Weekday  $weekday
   * @return \Illuminate\Http\Response
   */
  public function show(Weekday $weekday)
  {
    return view('weekdays.view', compact('weekday'));
  }

  /**
   * Show the form for editing the specified resource.
   *
   * @param  \App\Models\Weekday  $weekday
   * @return \Illuminate\Http\Response
   */
  public function edit(Weekday $weekday)
  {
    return view('weekdays.edit', compact('weekday'));
  }

  /**
   * Update the specified resource in storage.
   *
   * @param  \Illuminate\Http\Request  $request
   * @param  \App\Models\Weekday  $weekday
   * @return \Illuminate\Http\Response
   */
  public function update(Request $request, $codWeekday)
  {
    $request->validate([
      'txtName' => 'required',
      'txtDate' => 'required',
    ]);

    $weekday = Weekday::find($codWeekday);
    $weekday->name = $request->get('txtName');
    $weekday->date = $request->get('txtDate');


    $weekday->update();

    return redirect('/weekdays')->with('success', 'Weekday updated successfully');
  }

  /**
   * Remove the specified resource from storage.
   *
   * @param  \App\Models\Weekday  $weekday
   * @return \Illuminate\Http\Response
   */
  public function destroy(Weekday $weekday)
  {
    $weekday->delete();
    return redirect('/weekdays')->with('success', 'Weekday deleted successfully');
  }
}
