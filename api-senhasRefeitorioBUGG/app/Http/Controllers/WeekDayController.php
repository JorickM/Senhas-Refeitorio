<?php

namespace App\Http\Controllers;

use App\Models\weekday;
use Illuminate\Http\Request;

class WeekDayController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $weekdays = weekday::get()->toJson(JSON_PRETTY_PRINT);
        return response($weekdays, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
    {
        //
        $weekday = new weekday;
        $weekday->name = $request->name;
        $weekday->date = $request->date;
        $weekday->userLimit = $request->userLimit;
        $weekday->save();

        return response()->json([
            "message" => "weekday record created"
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
     * @param  \App\Models\weekday  $weekday
     * @return \Illuminate\Http\Response
     */
    public function show($codWeekday)
    {
        //
        if (weekday::where('codWeekday', $codWeekday)->exists()) {
            $weekday = weekday::where('codWeekday', $codWeekday)->get()->toJson(JSON_PRETTY_PRINT);
            return response($weekday, 200);
            } else {
            return response()->json([
                "message" => "weekday not found"
            ], 404);
        }
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\weekday  $weekday
     * @return \Illuminate\Http\Response
     */
    public function edit(weekday $weekday)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\weekday  $weekday
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $codWeekday)
    {
        //
        if (weekday::where('codWeekday', $codWeekday)->exists()) {
            $weekday = weekday::find($codWeekday);
            $weekday->name = is_null($request->name) ? $purchase->name : $request->name;
            $weekday->date = is_null($request->date) ? $purchase->date : $request->date;
            $weekday->userLimit = is_null($request->userLimit) ? $purchase->userLimit : $request->userLimit;
            $weekday->save();
    
            return response()->json([
                "message" => "records updated successfully"
            ], 200);
            } else {
            return response()->json([
                "message" => "userLimit not found"
            ], 404);
        }    
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\weekday  $weekday
     * @return \Illuminate\Http\Response
     */
    public function destroy($codWeekday)
    {
        //
        if(weekday::where('codWeekday', $codWeekday)->exists()) {
            $weekday = weekday::find($codWeekday);
            $weekday->delete();
    
            return response()->json([
              "message" => "records deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "purchase not found"
            ], 404);
          } 
    }
}
