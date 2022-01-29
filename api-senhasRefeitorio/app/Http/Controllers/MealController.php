<?php

namespace App\Http\Controllers;

use App\Models\Meal;
use Illuminate\Http\Request;

class MealController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $meal = Meal::get()->toJson(JSON_PRETTY_PRINT);
        return response($meal, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
    {
        $meal = new Meal;
        $meal->codWeekday = $request->codWeekday;
        $meal->mainDish = $request->mainDish;
        $meal->soup = $request->soup;
        $meal->desert = $request->desert;
        $meal->url = $request->url;
        $meal->save();
    
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
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function show($codMeal)
    {
        if (Meal::where('codMeal', $codMeal)->exists()) {
            $meal = Meal::where('codMeal', $codMeal)->get()->toJson(JSON_PRETTY_PRINT);
            return response($meal, 200);
          } else {
            return response()->json([
              "message" => "Student not found"
            ], 404);
          }
      }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function edit(Meal $meal)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request,$codMeal)
    {
        if (Meal::where('codMeal', $codMeal)->exists()) {
            $meal = Meal::find($codMeal);
            $meal->codWeekday = is_null($request->codWeekday) ? $meal->codWeekday : $request->codWeekday;
            $meal->mainDish = is_null($request->mainDish) ? $meal->mainDish : $request->mainDish;
            $meal->soup = is_null($request->soup) ? $meal->soup : $request->soup;
            $meal->desert = is_null($request->desert) ? $meal->desert : $request->desert;
            $meal->url = is_null($request->url) ? $meal->url : $request->url;
           
           
        
            $meal->save();
    
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
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function destroy($codMeal)
    {
        if(Meal::where('codMeal', $codMeal)->exists()) {
            $meal = Meal::find($codMeal);
            $meal->delete();
    
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
