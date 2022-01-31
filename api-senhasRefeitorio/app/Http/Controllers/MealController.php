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


    public function getAllMeals()
    {
        $meal = Meal::get()->toJson(JSON_PRETTY_PRINT);
        return response($meal, 200);
    }
    
    public function index()
    {
        $meals = Meal::all();
        return view('meals.list', compact('meals','meals'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
      return view('meals.create');
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
          'txtCodWeekday'=>'required',
          'txtMainDish' => 'required',
          'txtSoup' => 'required',
          'txtDesert' => 'required',
          'txtUrl' => 'required'
      ]);

      $meal = new Meal([
          'codWeekday' => $request->get('txtCodWeekday'),
          'mainDish'=> $request->get('txtMainDish'),
          'soup'=> $request->get('txtSoup'),
          'desert'=> $request->get('txtDesert'),
          'url'=> $request->get('txtUrl')
      ]);

      $meal->save();
      return redirect('/meals')->with('success', 'meal has been added');
  }
    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function show(Meal $meal)
    {
        return view('meals.view',compact('meal'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function edit(Meal $meal)
    {
      return view('meals.edit',compact('meal'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request ,$codMeal)
    {
          $request->validate([
            'txtCodWeekday'=>'required',
            'txtMainDish'=> 'required',
            'txtSoup' => 'required',
            'txtDesert' => 'required',
            'txtUrl' => 'required'
          ]);

        $meal = Meal::find($codMeal);
        $meal->codWeekday = $request->get('txtCodWeekday');
        $meal->mainDish = $request->get('txtMainDish');
        $meal->soup = $request->get('txtSoup');
        $meal->desert = $request->get('txtDesert');
        $meal->url = $request->get('txtUrl');

        $meal->update();

        return redirect('/meals')->with('success', 'Meal updated successfully');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Meal  $meal
     * @return \Illuminate\Http\Response
     */
    public function destroy(Meal $meal)
    {   
        $meal->delete();
        return redirect('/meals')->with('success', 'Meal deleted successfully');
      }
}
