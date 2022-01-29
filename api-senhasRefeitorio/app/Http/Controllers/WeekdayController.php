<?php

namespace App\Http\Controllers;

use App\Models\Weekday; 
use Illuminate\Http\Request;

class WeekdayController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $weekday = Weekday::get()->toJson(JSON_PRETTY_PRINT);
        return response($weekday, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
    {
        $weekday = new Weekday;
        $weekday->name = $request->name;
        $weekday->date = $request->date;
        $weekday->save();
    
        return response()->json([
            "message" => "student record created"
        ], 201);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Weekday  $weekday
     * @return \Illuminate\Http\Response
     */
    public function show($codWeekday)
    {
        if (Weekday::where('codWeekday', $codWeekday)->exists()) {
            $codWeekday = Weekday::where('codWeekday', $codWeekday)->get()->toJson(JSON_PRETTY_PRINT);
            return response($codWeekday, 200);
          } else {
            return response()->json([
              "message" => "Student not found"
            ], 404);
          }
      }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Weekday  $weekday
     * @return \Illuminate\Http\Response
     */
    public function edit(Weekday $weekday)
    {

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
        if (Weekday::where('codWeekday', $codWeekday)->exists()) {
            $weekday = Weekday::find($codWeekday);
            $weekday->name = is_null($request->name) ? $weekday->name : $request->name;
            $weekday->date = is_null($request->date) ? $weekday->date : $request->date;
           
            $weekday->save();
            return response()->json([
                "message" => "records updated successfully"
            ], 200);
            } else {
            return response()->json([
                "message" => "Student not found"
            ], 404);
            
        }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Weekday  $weekday
     * @return \Illuminate\Http\Response
     */
    public function destroy($codWeekday)
    {
        if(Weekday::where('codWeekday', $codWeekday)->exists()) {
            $weekday = Weekday::find($codWeekday);
            $weekday->delete();
    
            return response()->json([
              "message" => "records deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "Student not found"
            ], 404);
          }
        }
}
