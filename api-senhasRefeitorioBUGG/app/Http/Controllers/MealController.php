<?php

namespace App\Http\Controllers;

use App\Models\meal;
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
        $meals = meal::get()->toJson(JSON_PRETTY_PRINT);
        return response($meals, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create(Request $request)
    {
        //
        $meal = new meal;
        $meal->codWeekday = $request->codWeekday;
        $meal->codMealType = $request->codMealType;
        $meal->mainDish = $request->mainDish;
        $meal->userLimit = $request->userLimit;
        $meal->soup = $request->soup;
        $meal->desert = $request->desert;
        $meal->save();

        return response()->json([
            "message" => "meal record created"
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
     * @param  \App\Models\meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function show($codMeal)
    {
        //
        if (meal::where('codMeal', $codMeal)->exists()) {
            $meal = meal::where('codMeal', $codMeal)->get()->toJson(JSON_PRETTY_PRINT);
            return response($meal, 200);
          } else {
            return response()->json([
              "message" => "meal not found"
            ], 404);
        }
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function edit(meal $meal)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $codMeal)
    {
        //
        if (meal::where('codMeal', $codMeal)->exists()) {
            $meal = meal::find($codMeal);
            $meal->codMealType = is_null($request->codMealType) ? $meal->codMealType : $request->codMealType;
            $meal->mainDish = is_null($request->mainDish) ? $meal->mainDish : $request->mainDish;
            $meal->userLimit = is_null($request->userLimit) ? $meal->userLimit : $request->userLimit;
            $meal->soup = is_null($request->soup) ? $meal->soup : $request->soup;
            $meal->desert = is_null($request->desert) ? $meal->desert : $request->desert;
            $meal->save();
    
            return response()->json([
                "message" => "records updated successfully"
            ], 200);
            } else {
            return response()->json([
                "message" => "meal not found"
            ], 404);
        }
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function destroy($codMeal)
    {
        //
        if(meal::where('codMeal', $codMeal)->exists()) {
            $meal = meal::find($codMeal);
            $meal->delete();
    
            return response()->json([
              "message" => "records deleted"
            ], 202);
          } else {
            return response()->json([
              "message" => "meal not found"
            ], 404);
          }
    }
}
