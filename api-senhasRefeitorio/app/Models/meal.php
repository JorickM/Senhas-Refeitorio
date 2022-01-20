<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class meal extends Model
{
    use HasFactory;
    protected $table = 'meals';
    protected $fillable = ['codMeal', 'codWeekday', 'codMealType', 'mainDish', 'userLimit', 'soup', 'desert'];
}
